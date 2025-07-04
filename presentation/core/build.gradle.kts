plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.android.base)
    alias(libs.plugins.project.android.compose)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "presentation.core"
}

dependencies {
    api(libs.decompose.core)
    api(libs.decompose.compose)

    implementation(libs.reaktive.main)

    implementation(projects.util.debugging)
}
