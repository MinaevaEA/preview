package presentation.uikit.theme

import androidx.compose.foundation.LocalIndication
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import presentation.uikit.theme.colors.LocalColors
import presentation.uikit.theme.colors.darkPalette
import presentation.uikit.theme.colors.lightPalette
import presentation.uikit.theme.typography.LocalTypography
import presentation.uikit.theme.typography.appTypography

@Composable
fun AppTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val palette = if (darkTheme) darkPalette else lightPalette
    val rippleIndications = ripple()

    CompositionLocalProvider(
        LocalColors provides palette,
        LocalTypography provides appTypography,
        LocalIndication provides rippleIndications,
        content = content
    )
}

val AppColors
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current

val AppTypography
    @Composable
    @ReadOnlyComposable
    get() = LocalTypography.current

