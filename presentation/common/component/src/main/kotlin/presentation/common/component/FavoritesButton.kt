package presentation.common.component

import androidx.compose.animation.AnimatedContent
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import presentation.resources.R
import presentation.uikit.theme.AppColors
import presentation.uikit.theme.AppTheme

@Composable
fun FavoritesButton(
    isFavorite: Boolean,
    onClick: () -> Unit
) {
    val iconRes = remember(isFavorite) {
        if (isFavorite) R.drawable.ic_tab_favorites_filled else R.drawable.ic_tab_favorites
    }
    val tint = if (isFavorite) AppColors.accent30 else AppColors.neutral50

    IconButton(
        onClick = onClick,
        colors = IconButtonColors(
            containerColor = Color.Transparent,
            contentColor = tint,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = tint
        )
    ) {
        AnimatedContent(
            targetState = iconRes
        ) { target ->
            Icon(
                painter = painterResource(target),
                contentDescription = "Toggle favorites",
            )
        }
    }

}

@Composable
@Preview(showBackground = true)
private fun FavoritesButtonPreview() {
    AppTheme {
        var isFavorite by remember { mutableStateOf(false) }
        FavoritesButton(
            isFavorite = isFavorite,
            onClick = { isFavorite = !isFavorite }
        )
    }
}
