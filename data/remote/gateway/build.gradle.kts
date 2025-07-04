plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.project.android.base)
    alias(libs.plugins.project.android.hilt)
}

android {
    namespace = "data.remote.gateway"

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        buildConfigField("String", "BASE_URL", "\"https://\"")
    }
}

dependencies {
    implementation(libs.okhttp)
    debugImplementation(libs.okhttp.logging)

    implementation(libs.retrofit.core)
    implementation(libs.retrofit.conventer.kotlinx)

    implementation(libs.kotlinx.serialization.json)

    implementation(libs.reaktive.main)
    implementation(libs.reaktive.coroutines)

    implementation(projects.data.local.keystorage)
    implementation(projects.data.local.db)

    implementation(projects.util.exception)
    implementation(projects.util.debugging)
}
