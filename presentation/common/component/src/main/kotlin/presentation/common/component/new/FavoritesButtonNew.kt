package presentation.common.component.new

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import presentation.uikit.theme.AppColors
import presentation.resources.R
import presentation.uikit.theme.AppTheme

@Composable
fun FavoritesButtonNew(
    modifier: Modifier = Modifier,
    isFavorite: Boolean,
    onClick: () -> Unit
) {
    val bgTint by animateColorAsState(if (isFavorite) AppColors.accent0 else AppColors.neutral0)
    val iconTint by animateColorAsState(if (isFavorite) AppColors.accent20 else AppColors.neutral10)

    Box(
        modifier = modifier
            .wrapContentSize()
            .clip(CircleShape)
            .clickable { onClick() }
            .background(bgTint)
            .padding(6.dp)
    ) {
        Icon(
            modifier = Modifier.size(16.dp),
            painter = painterResource(R.drawable.ic_tab_favorites_filled),
            tint = iconTint,
            contentDescription = "favorites_button"
        )
    }
}

@Composable
@Preview
private fun FavoritesButtonPreview() {
    AppTheme {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            FavoritesButtonNew(
                isFavorite = false,
                onClick = {}
            )

            FavoritesButtonNew(
                isFavorite = true,
                onClick = {}
            )
        }
    }
}
