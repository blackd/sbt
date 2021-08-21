import org.anti_ad.mc.configureCompilation
import org.anti_ad.mc.configureDependencies
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `java-library`
    `maven-publish`
    //kotlin("jvm") version "1.5.21"
    idea
    antlr
}

configureCompilation()
configureDependencies()

group = "org.anti_ad.mc.common"

dependencies {
    "shadedApi"("commons-io:commons-io:2.6")
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

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    languageVersion = "1.5"
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
//            artifact(tasks["sourcesJar"])
            artifact(tasks["jar"])
        }
    }

    repositories {
        val mavenUrl = "https://repo.codemc.io/repository/maven-releases/"
        val mavenSnapshotUrl = "https://repo.codemc.io/repository/maven-snapshots/"

        maven(mavenUrl) {
            val mavenUsername: String? by project
            val mavenPassword: String? by project
            if (mavenUsername != null && mavenPassword != null) {
                credentials {
                    username = mavenUsername
                    password = mavenPassword
                }
            }
        }
    }
}