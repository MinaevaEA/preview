plugins {
    alias(libs.plugins.project.android.feature)
}

android {
    namespace = "feature.main.container"
}

dependencies {
    implementation(projects.presentation.feature.main.navbar)
    implementation(projects.presentation.feature.lectures.detail)
    implementation(projects.presentation.feature.category.select)
    implementation(projects.presentation.feature.category.detail)
}
