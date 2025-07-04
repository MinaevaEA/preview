plugins {
    alias(libs.plugins.project.android.feature)
}

android {
    namespace = "feature.main.navbar"
}

dependencies {
    implementation(projects.presentation.feature.lectures.list)
    implementation(project(":presentation:feature:favorites"))
}
