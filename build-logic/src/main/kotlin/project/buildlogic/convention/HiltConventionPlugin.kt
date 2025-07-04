package project.buildlogic.convention

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import project.buildlogic.extensions.getPluginId
import project.buildlogic.extensions.libs
import project.buildlogic.extensions.addImplementation
import project.buildlogic.extensions.addKsp
import project.buildlogic.extensions.getLibrary

class HiltConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.run {
                apply(libs.getPluginId("devtools-ksp"))
                apply(libs.getPluginId("hilt"))
            }

            dependencies {
                addImplementation(libs.getLibrary("hilt-android"))
                addKsp(libs.getLibrary("hilt-compiler"))
            }
        }
    }

}
