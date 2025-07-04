plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.android.base)
    alias(libs.plugins.project.android.hilt)
}

android {
    namespace = "util.debugging"
}

dependencies {
    implementation(libs.okhttp)

    debugImplementation(libs.mmkv)
    debugImplementation(libs.flipper.main)
    debugImplementation(libs.soloader)
    debugImplementation(libs.flipper.plugin.network)

    debugImplementation(libs.timber)

    debugImplementation(libs.okhttp.logging)
    debugImplementation(libs.kotlinx.serialization.json)
}

