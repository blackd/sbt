plugins {
    `kotlin-dsl`
    kotlin("jvm") version "1.6.0"
    id("com.github.johnrengelman.shadow") version "7.1.0"
}


repositories {
    mavenCentral()
    gradlePluginPortal()
}

buildscript {
    repositories {
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath("gradle.plugin.com.github.johnrengelman:shadow:7.1.0")
    }
}


dependencies {
    implementation("gradle.plugin.com.github.johnrengelman:shadow:7.1.0")
}

val compileKotlin: org.jetbrains.kotlin.gradle.tasks.KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
