package presentation.uikit.theme.typography

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit

@Immutable
class AppFont(
    private val fontSize: TextUnit,
    private val lineHeight: TextUnit
) {

    val regular = TextStyle(
        fontFamily = primaryFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = fontSize,
        lineHeight = lineHeight
    )

    val medium = TextStyle(
        fontFamily = primaryFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = fontSize,
        lineHeight = lineHeight
    )

    val semibold = TextStyle(
        fontFamily = primaryFontFamily,
        fontWeight = FontWeight.W600,
        fontSize = fontSize,
        lineHeight = lineHeight
    )

    val bold = TextStyle(
        fontFamily = primaryFontFamily,
        fontWeight = FontWeight.W700,
        fontSize = fontSize,
        lineHeight = lineHeight
    )

    fun byWeight(weight: FontWeight) = TextStyle(
        fontFamily = primaryFontFamily,
        fontWeight = weight,
        fontSize = fontSize,
        lineHeight = lineHeight
    )

}
