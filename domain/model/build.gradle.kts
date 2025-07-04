plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.android.base)
}

android {
    namespace = "domain.model"
}

dependencies {
    implementation(projects.util.exception)
    implementation(projects.data.remote.gateway)
    implementation(projects.data.local.db)
    implementation(projects.presentation.model)
}
