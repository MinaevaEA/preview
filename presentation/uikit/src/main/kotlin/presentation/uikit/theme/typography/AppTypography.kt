package presentation.uikit.theme.typography

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.sp

@Immutable
data class AppTypography(
    val captionSmall: AppFont,
    val caption: AppFont,
    val label: AppFont,
    val bodyLarge: AppFont,
//    val bodySmall: AppFont,
//    val bodyMedium: AppFont,
    val bodySmall: AppFont,
    val bodyMedium: AppFont,
//    val bodyLarge: AppFont,
    val bodyXLarge: AppFont,
//    val heading: AppFontHeading,
)

val appTypography = AppTypography(
    captionSmall = AppFont(
        fontSize = 10.sp,
        lineHeight = 12.sp
    ),
    caption = AppFont(
        fontSize = 12.sp,
        lineHeight = 16.sp
    ),
    bodyLarge = AppFont(
        fontSize = 16.sp,
        lineHeight = 22.sp
    ),
    label = AppFont(
        fontSize = 14.sp,
        lineHeight = 22.sp
    ),
//    bodySmall = AppFont(
//        fontSize = 12.sp,
//        lineHeight = 20.4.sp,
//    ),
//    bodyMedium = AppFont(
//        fontSize = 14.sp,
//        lineHeight = 23.1.sp
//    ),
   bodySmall = AppFont(
        fontSize = 10.sp,
        lineHeight = 22.sp,
   ),
   bodyMedium = AppFont(
        fontSize = 12.sp,
       lineHeight = 22.sp
    ),
    bodyXLarge = AppFont(
        fontSize = 20.sp,
        lineHeight = 22.sp
    ),
//    bodyXLarge = AppFont(
//        fontSize = 18.sp,
//        lineHeight = 27.sp
//    ),
//    heading = AppFontHeading()
)

val LocalTypography = staticCompositionLocalOf<AppTypography> {
    error("No typography provided")
}

