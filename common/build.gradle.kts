import org.anti_ad.mc.configureCompilation
import org.anti_ad.mc.configureDependencies
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") //version "1.6.21"
    kotlin("plugin.serialization") //version "1.6.21"
    `java-library`
    idea
}

configureCompilation()
configureDependencies()

group = "org.anti_ad.mc.common"

dependencies {
    "shadedApi"("commons-io:commons-io:2.11.0")
    "compileOnly"(group = "com.google.code.gson",
                  name = "gson",
                  version = "2.8.7")
    "compileOnlyApi"(group = "org.apache.logging.log4j",
                     name = "log4j-api",
                     version = "2.14.1")
    /*
    "runtimeOnly"(group = "org.apache.logging.log4j",
                  name = "log4j-core",
                  version = "2.14.1")

     */
    "compileOnlyApi"(group = "org.lwjgl",
                     name = "lwjgl-glfw",
                     version = "3.2.2")

}

tasks.named<KotlinCompile>("compileKotlin") {
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-opt-in=kotlin.ExperimentalStdlibApi")
    }
}
repositories {
    mavenCentral()
}
