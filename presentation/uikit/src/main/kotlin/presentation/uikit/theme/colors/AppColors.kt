package presentation.uikit.theme.colors

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class AppColors(
    val neutral0: Color,
    val neutral10: Color,
    val neutral20: Color,
    val neutral30: Color,
    val neutral40: Color,
    val neutral50: Color,
    val neutral60: Color,
    val neutral70: Color,
    val neutral80: Color,
    val neutral90: Color,
    val neutral95: Color,
    val neutral100: Color,

    val accent0: Color,
    val accent10: Color,
    val accent20: Color,
    val accent30: Color,
    val accent40: Color,
    val accent50: Color,
    val accent60: Color,
    val accent70: Color,
    val accent80: Color,
    val accent90: Color,
    val accent95: Color,
    val accent100: Color,

    val pink: Color
)

val LocalColors = staticCompositionLocalOf<AppColors> {
    error("no colors provided")
}
