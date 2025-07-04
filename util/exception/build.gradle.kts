plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.project.android.base)
}

android {
    namespace = "util.exception"
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
}

