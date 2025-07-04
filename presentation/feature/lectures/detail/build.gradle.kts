plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.android.base)
    alias(libs.plugins.project.android.compose)
    alias(libs.plugins.project.android.feature)
}

android {
    namespace = "feature.lectures.detail"
}

dependencies {
    implementation(projects.presentation.core)
    implementation(projects.presentation.model)
    implementation(projects.presentation.common.component)
}
