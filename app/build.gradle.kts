plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.project.android.base)
    alias(libs.plugins.project.android.hilt)
    alias(libs.plugins.project.android.compose)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "ru.boostconf.app"

    defaultConfig {
        applicationId = "ru.boostconf.app"
        versionCode = 1
        versionName = "1.0"
    }

    signingConfigs {
        create("release") {
            storeFile = file("../key.jks")
            storePassword = "313211707"
            keyAlias = "key0"
            keyPassword = "313211707"
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("release")
        }
    }
}

dependencies {
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.core.splashscreen)

    implementation(projects.presentation.core)
    implementation(projects.presentation.uikit)
    implementation(projects.presentation.feature.root)
}
