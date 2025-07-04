import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektCreateBaselineTask

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.kotlin.parcelize) apply false
    alias(libs.plugins.google.service) apply false
    alias(libs.plugins.detekt)
    alias(libs.plugins.devtools.ksp) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.jetbrainsKotlinJvm) apply false
}

detekt {
    toolVersion = libs.versions.detekt.get()
    source.setFrom(projectDir)
    config.setFrom("$rootDir/config/detekt/detekt.yml")
    buildUponDefaultConfig = true
}

tasks.register<Detekt>("detektAll") {
    description = "Detekt build for all modules"
    parallel = true
    ignoreFailures = false
    autoCorrect = project.hasProperty("detektAutoFix")
    buildUponDefaultConfig = true
    setSource(file(projectDir))
    config.setFrom(file("config/detekt/detekt.yml"))
    include("**/*.kt")
    exclude("**/resources/**", "**/build/**")
    reports {
        xml.required.set(false)
        html.required.set(true)
        txt.required.set(false)
        sarif.required.set(false)
        md.required.set(false)

        html.outputLocation.set(file("build/reports/detekt.html"))
    }
}

tasks.withType<Detekt>().configureEach {
    jvmTarget = "17"
}

tasks.withType<DetektCreateBaselineTask>().configureEach {
    jvmTarget = "17"
}


