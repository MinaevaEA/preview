package project.buildlogic.convention

import com.android.build.gradle.AppExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.findByType
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile
import project.buildlogic.extensions.getPluginId
import project.buildlogic.extensions.getVersion
import project.buildlogic.extensions.libs

class BaseConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.run {
                apply(libs.getPluginId("kotlin-android"))
            }

            if (extensions.findByType<LibraryExtension>() != null) {
                extensions.configure<LibraryExtension> {
                    defaultConfig {
                        compileSdk = libs.getVersion("compileSdk").toInt()
                        minSdk = libs.getVersion("minSdk").toInt()

                        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

                        vectorDrawables {
                            useSupportLibrary = true
                        }
                    }

                    compileOptions {
                        sourceCompatibility = JavaVersion.VERSION_17
                        targetCompatibility = JavaVersion.VERSION_17
                    }
                }
            } else {
                extensions.configure<AppExtension> {
                    compileSdkVersion(libs.getVersion("compileSdk").toInt())

                    defaultConfig {
                        targetSdk = libs.getVersion("targetSdk").toInt()
                        minSdk = libs.getVersion("minSdk").toInt()

                        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

                        vectorDrawables {
                            useSupportLibrary = true
                        }
                    }

                    compileOptions {
                        sourceCompatibility = JavaVersion.VERSION_17
                        targetCompatibility = JavaVersion.VERSION_17
                    }
                }
            }

            tasks.withType<KotlinJvmCompile>().configureEach {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_17)
                }
            }
        }
    }

}
