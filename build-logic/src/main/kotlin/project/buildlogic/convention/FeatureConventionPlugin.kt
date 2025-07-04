package project.buildlogic.convention

import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension
import org.jetbrains.kotlin.gradle.dsl.kotlinExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile
import project.buildlogic.extensions.addDebugImplementation
import project.buildlogic.extensions.addImplementation
import project.buildlogic.extensions.addKsp
import project.buildlogic.extensions.getBundle
import project.buildlogic.extensions.getPluginId
import project.buildlogic.extensions.getVersion
import project.buildlogic.extensions.libs

class FeatureConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.run {
                apply(libs.getPluginId("android-library"))
                apply(libs.getPluginId("kotlin-serialization"))
                apply(libs.getPluginId("project-android-base"))
                apply(libs.getPluginId("project-android-hilt"))
                apply(libs.getPluginId("project-android-compose"))
            }

            extensions.configure<KotlinProjectExtension> {
                explicitApi()
            }

            dependencies {
                addImplementation(libs.getBundle("feature-base"))

                addImplementation(project(":presentation:core"))
                addImplementation(project(":presentation:model"))
                addImplementation(project(":presentation:uikit"))
                addImplementation(project(":presentation:resources"))
                addImplementation(project(":presentation:common:component"))
                addImplementation(project(":domain:usecase"))

                addImplementation(project(":util:debugging"))
                addImplementation(project(":util:exception"))
            }
        }
    }

}
