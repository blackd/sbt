package org.anti_ad.mc
import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.api.plugins.BasePluginConvention

import org.gradle.kotlin.dsl.*

fun Project.configureDistribution(is18: Boolean) {
    apply(plugin = "java-library")
    apply(plugin = "com.github.johnrengelman.shadow")



    convention.getPlugin<BasePluginConvention>().archivesBaseName = project.name

    tasks.named<DefaultTask>("build") {
        dependsOn(tasks.findByPath(":common:build"))
        dependsOn(tasks["shadowJar"])
    }

}
