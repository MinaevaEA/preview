plugins {
    alias(libs.plugins.project.android.feature)
}

android {
    namespace = "presentation.feature.category.select"

}
dependencies {
    implementation(project(":presentation:feature:lectures:detail"))
}
