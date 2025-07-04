package presentation.uikit.theme.typography

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import presentation.uikit.R

val primaryFontFamily = FontFamily(
    Font(R.font.gilroy_regular, FontWeight.W400),
    Font(R.font.gilroy_medium, FontWeight.W500),
    Font(R.font.gilroy_semibold, FontWeight.W600),
    Font(R.font.gilroy_bold, FontWeight.W700),
    Font(R.font.gilroy_extra_bold, FontWeight.W800)
)

val secondaryFontFamily = FontFamily(
    Font(R.font.ibmplex_mono_regular, FontWeight.W400),
    Font(R.font.ibmplex_mono_medium, FontWeight.W500),
    Font(R.font.ibmplex_mono_semibold, FontWeight.W600),
    Font(R.font.ibmplex_mono_bold, FontWeight.W700)
)
