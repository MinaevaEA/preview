package presentation.uikit.theme.typography.style

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import presentation.uikit.theme.typography.primaryFontFamily

@Immutable
class AppFontHeading {

    val h1 = TextStyle(
        fontFamily = primaryFontFamily,
        fontWeight = FontWeight.W700,
        fontSize = 48.sp,
        lineHeight = 62.4.sp
    )

    val h2 = TextStyle(
        fontFamily = primaryFontFamily,
        fontWeight = FontWeight.W700,
        fontSize = 40.sp,
        lineHeight = 56.sp
    )

    val h3 = TextStyle(
        fontFamily = primaryFontFamily,
        fontWeight = FontWeight.W700,
        fontSize = 28.sp,
        lineHeight = 42.sp
    )

    val h4 = TextStyle(
        fontFamily = primaryFontFamily,
        fontWeight = FontWeight.W700,
        fontSize = 24.sp,
        lineHeight = 36.sp
    )

    val h5 = TextStyle(
        fontFamily = primaryFontFamily,
        fontWeight = FontWeight.W700,
        fontSize = 20.sp,
        lineHeight = 30.sp
    )

    val h6 = TextStyle(
        fontFamily = primaryFontFamily,
        fontWeight = FontWeight.W700,
        fontSize = 16.sp,
        lineHeight = 24.sp
    )

}
