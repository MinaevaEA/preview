package ru.boostconf.app.common.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import feature.root.RootComponent
import feature.root.RootScreen
import presentation.uikit.theme.AppColors
import presentation.uikit.theme.AppTheme

@Composable
fun CommonActivityView(rootComponent: RootComponent) {
    AppTheme(darkTheme = isSystemInDarkTheme()) {
        Surface(
            color = AppColors.neutral95
        ) {
            RootScreen(rootComponent)
        }
    }
}
