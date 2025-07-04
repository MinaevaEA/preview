plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.android.base)
    alias(libs.plugins.project.android.hilt)
}

android {
    namespace = "domain.repository"
}

dependencies {
    implementation(libs.reaktive.main)

    implementation(projects.data.local.keystorage)
    implementation(projects.data.local.db)
    implementation(projects.data.remote.gateway)

    implementation(projects.domain.model)

    implementation(projects.util.exception)
    implementation(projects.util.debugging)
}
