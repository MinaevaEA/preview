import org.gradle.internal.impldep.org.eclipse.jgit.merge.MergeStrategy.register
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "mendev.build_logic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.build.android)
    compileOnly(libs.build.kotlin)
    compileOnly(libs.build.ksp)
}
gradlePlugin {
    plugins {
        register("androidBase") {
            id = libs.plugins.project.android.base.get().pluginId
            implementationClass = "project.buildlogic.convention.BaseConventionPlugin"
        }

        register("androidHilt") {
            id = libs.plugins.project.android.hilt.get().pluginId
            implementationClass = "project.buildlogic.convention.HiltConventionPlugin"
        }

        register("androidCompose") {
            id = libs.plugins.project.android.compose.get().pluginId
            implementationClass = "project.buildlogic.convention.ComposeConventionPlugin"
        }

        register("androidFeature") {
             id = libs.plugins.project.android.feature.get().pluginId
            implementationClass = "project.buildlogic.convention.FeatureConventionPlugin"
        }

    }
}

