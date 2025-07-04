package project.buildlogic.convention

import com.android.build.gradle.AppExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.findByType
import project.buildlogic.extensions.addDebugImplementation
import project.buildlogic.extensions.addImplementation
import project.buildlogic.extensions.getBundle
import project.buildlogic.extensions.getLibrary
import project.buildlogic.extensions.getPluginId
import project.buildlogic.extensions.libs


class ComposeConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.run {
                apply(libs.getPluginId("compose-compiler"))
            }

            if (extensions.findByType<LibraryExtension>() != null) {
                extensions.configure<LibraryExtension> {
                    buildFeatures {
                        compose = true
                    }
                }
            } else {
                extensions.configure<AppExtension> {
                    buildFeatures.compose = true
                }
            }

            dependencies {
                addImplementation(libs.getBundle("compose"))
                addDebugImplementation(libs.getBundle("compose-debug"))
            }
        }
    }

}
