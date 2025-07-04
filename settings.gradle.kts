enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Boost"
include(":app")
include(":util:debugging")
include(":util:exception")
include(":data:remote:gateway")
include(":data:local:keystorage")
include(":data:local:db")
include(":domain:repository")
include(":domain:usecase")
include(":domain:model")
include(":presentation:core")
include(":presentation:uikit")
include(":presentation:model")
include(":presentation:resources")
include(":presentation:feature:root")
include(":presentation:feature:main:container")
include(":presentation:feature:main:navbar")
include(":presentation:feature:lectures:list")
include(":presentation:common:component")
include(":presentation:feature:lectures:detail")
include(":presentation:feature:flow:select")
include(":presentation:feature:flow:detail")
include(":presentation:feature:category:select")
include(":presentation:feature:category:detail")
include(":presentation:feature:favorites")
