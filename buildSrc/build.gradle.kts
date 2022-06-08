plugins {
    `kotlin-dsl`
    kotlin("jvm") version "1.6.0"
}


repositories {
    mavenCentral()
    gradlePluginPortal()
}


dependencies {

}

val compileKotlin: org.jetbrains.kotlin.gradle.tasks.KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
