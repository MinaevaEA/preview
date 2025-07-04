package project.buildlogic.extensions

import org.gradle.api.artifacts.ExternalModuleDependency
import org.gradle.api.artifacts.ExternalModuleDependencyBundle
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.provider.Provider

fun VersionCatalog.getPluginId(alias: String): String = this
    .findPlugin(alias)
    .get()
    .get()
    .pluginId

fun VersionCatalog.getVersion(alias: String): String = this
    .findVersion(alias)
    .get()
    .requiredVersion

fun VersionCatalog.getLibrary(alias: String): Provider<MinimalExternalModuleDependency> = this
    .findLibrary(alias)
    .get()

fun VersionCatalog.getBundle(alias: String): Provider<ExternalModuleDependencyBundle> = this
    .findBundle(alias)
    .get()
