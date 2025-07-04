plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.android.base)
    alias(libs.plugins.project.android.compose)
}

android {
    namespace = "presentation.common.component"
}

dependencies {
    implementation(projects.presentation.uikit)
    implementation(projects.presentation.model)
    implementation(projects.presentation.resources)

    implementation(libs.kotlinx.collections.immutable)
    implementation(libs.coil.compose)
}
