plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.android.base)
    alias(libs.plugins.project.android.hilt)
}

android {
    namespace = "data.local.db"
}

dependencies {
    implementation(libs.room.core)
    implementation(libs.room.coroutines)
    ksp(libs.room.compiler)

    implementation(libs.reaktive.main)
    implementation(libs.reaktive.coroutines)

    implementation(projects.util.exception)
    implementation(projects.util.debugging)
}
