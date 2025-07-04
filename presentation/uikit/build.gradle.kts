plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.android.base)
    alias(libs.plugins.project.android.compose)
}

android {
    namespace = "presentation.uikit"
}

dependencies {
    implementation(projects.presentation.core)

    implementation(libs.kotlinx.collections.immutable)
}
