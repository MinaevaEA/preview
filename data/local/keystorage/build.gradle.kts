plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.android.base)
    alias(libs.plugins.project.android.hilt)
}

android {
    namespace = "data.local.keystorage"

    defaultConfig {
        buildConfigField("String", "MMKV_KEY", "\"WFwaDFz5EIkgMWUo\"")
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(libs.mmkv)
    implementation(libs.reaktive.main)

    implementation(projects.util.debugging)
    implementation(projects.util.exception)
}
