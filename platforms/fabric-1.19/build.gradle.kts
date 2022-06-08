import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import net.fabricmc.loom.task.RemapJarTask
import org.anti_ad.mc.configureCommon
import proguard.gradle.ProGuardTask

val supported_minecraft_versions = listOf("1.19")
val mod_loader = "fabric"
val mod_version = project.version.toString()
val minecraft_version = "1.19"
val mappings_version = "1.19+build.1"
val loader_version = "0.14.6"
val modmenu_version = "4.0.0-beta.4"
val fabric_api_version = "0.55.2+1.19"




logger.lifecycle("""
    ***************************************************
    Processing "${project.path}"
    supported versions: $supported_minecraft_versions
    loader: $mod_loader
    mod version: $mod_version
    building against MC: $minecraft_version
    loom version: $loom_version_117
    ***************************************************
    """.trimIndent())

plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    idea
    `java-library`
    id("fabric-loom")
}

configureCommon()

group = "org.anti_ad.mc.fabric_1_17"

configure<JavaPluginExtension> {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

val compileKotlin: org.jetbrains.kotlin.gradle.tasks.KotlinCompile by tasks
compileKotlin.kotlinOptions {
    languageVersion = "1.5"
    jvmTarget = "17"
}

dependencies {
    "shadedApi"(project(":common"))
    implementation("org.apache.commons:commons-rng-core:1.3")
    implementation("commons-io:commons-io:2.4")

    implementation("com.guardsquare:proguard-gradle:7.2.0-beta2")
    minecraft("com.mojang:minecraft:$minecraft_version")
    mappings("net.fabricmc:yarn:$mappings_version:v2")
    modImplementation("net.fabricmc:fabric-loader:$loader_version")
    modImplementation("com.terraformersmc:modmenu:$modmenu_version")
    modImplementation("net.fabricmc.fabric-api:fabric-api:$fabric_api_version")
}

loom {

    runConfigs["client"].runDir = "run/1.19.x"
    //runConfigs["client"].programArg("--username=DEV")
    runConfigs["client"].programArgs.addAll(listOf<String>("--width=1280", "--height=720", "--username=DEV"))
    //--width=1280, --height=720
    mixin.defaultRefmapName.set("smallbuildtweaks-refmap.json")
}

tasks.named<ShadowJar>("shadowJar") {

    configurations = listOf(project.configurations["shaded"])

    archiveClassifier.set("shaded")
    setVersion(project.version)

    relocate("org.antlr", "org.anti_ad.mc.sbt.common.embedded.org.antlr")
    relocate("org.apache.commons", "org.anti_ad.mc.sbt.common.embedded.org.apache.commons")
    relocate("kotlin", "org.anti_ad.mc.sbt.common.embedded.kotlin")

    //include("assets/**")

    exclude("**/*.kotlin_metadata")
    exclude("**/*.kotlin_module")
    exclude("**/*.kotlin_builtins")
    exclude("**/*_ws.class") // fixme find a better solution for removing *.ws.kts
    exclude("**/*_ws$*.class")
    exclude("mappings/mappings.tiny") // before kt, build .jar don"t have this folder (this 500K thing)
    exclude("com/ibm/**")
    exclude("org/glassfish/**")
    exclude("org/intellij/**")
    exclude("org/jetbrains/**")
    exclude("org/jline/**")
    exclude("net/minecraftforge/**")
    exclude("io/netty/**")
    //exclude("mappings/mappings.tiny") // before kt, build .jar don"t have this folder (this 500K thing)
    exclude("META-INF/maven/**")
    exclude("META-INF/LICENSE")
    exclude("META-INF/README")
    minimize()
}

afterEvaluate {

    tasks.register<Copy>("injectCommonResources") {
        dependsOn(":common:processResources")
        from(project(":common").layout.buildDirectory.dir("resources/main"))
        include("assets/**")
        into(project.layout.buildDirectory.dir("resources/main"))
    }

    tasks.register<Delete>("removeCommonResources") {
        this.delete(project.layout.buildDirectory.dir("resources/main/assets"))
    }

    tasks.getByName("runClient") {
        dependsOn("injectCommonResources")
        finalizedBy("removeCommonResources")
    }
    tasks.named<Task>("prepareRemapJar") {
        val proGuardTask = tasks.getByName<Task>("proguard")
        mustRunAfter(proGuardTask)
    }
}

tasks.named<DefaultTask>("build") {
    dependsOn(tasks["remapJar"])
}

val proguard by tasks.registering(ProGuardTask::class) {

    configuration("../../proguard.txt")

    // project(":platforms:fabric_1_17").tasks.named<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar>("shadowJar").get().archiveFileName
    val fabricRemapJar = tasks.named<ShadowJar>("shadowJar").get()
    val inName = fabricRemapJar.archiveFile.get().asFile.absolutePath

    injars(inName)
    outjars("build/libs/${fabricRemapJar.archiveBaseName.get()}-all-proguard.jar")

    doFirst {
        libraryjars( configurations.runtimeClasspath.get().files.filter {
            !it.name.contains("smallbuildtweaks-common")
        })
    }
    dependsOn(tasks["shadowJar"])
}

val remapped = tasks.named<RemapJarTask>("remapJar") {
    group = "fabric"
    val shadowJar = tasks.getByName<ShadowJar>("shadowJar")
    val proGuardTask = tasks.getByName<ProGuardTask>("proguard")
    dependsOn(proGuardTask)
    input.set( File("build/libs/${shadowJar.archiveBaseName.get()}-all-proguard.jar"))
    val finalName = shadowJar.archiveFileName.get().replace(Regex("-shaded\\.jar$"), ".jar")
    logger.lifecycle("&&&&&&&&&&& final jar name $finalName")
    archiveFileName.set(finalName)
    addNestedDependencies.set(true)
    //addDefaultNestedDependencies.set(false)
    //remapAccessWidener.set(true)
}
