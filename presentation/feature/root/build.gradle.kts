plugins {
    alias(libs.plugins.project.android.feature)
}

android {
    namespace = "feature.root"
}

dependencies {
    implementation(projects.presentation.feature.main.container)
}
