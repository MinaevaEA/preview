plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.android.base)
    alias(libs.plugins.project.android.hilt)
}

android {
    namespace = "domain.usecase"
}

dependencies {
    implementation(libs.reaktive.main)
    implementation(libs.kotlinx.collections.immutable)

    implementation(libs.paging.core)

    implementation(projects.domain.model)
    implementation(projects.domain.repository)

    implementation(projects.presentation.model)

    implementation(projects.util.exception)
    implementation(projects.util.debugging)
}
