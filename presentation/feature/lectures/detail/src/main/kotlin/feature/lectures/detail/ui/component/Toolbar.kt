package feature.lectures.detail.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import presentation.common.component.FavoritesButton
import presentation.resources.R
import presentation.uikit.theme.AppTheme

@Composable
internal fun Toolbar(
    modifier: Modifier,
    favoriteClick: () -> Unit,
    backClick: () -> Unit,
    isFavorite: Boolean
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(
            onClick = backClick,
            colors = IconButtonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Unspecified,
                disabledContainerColor = Color.Transparent,
                disabledContentColor = Color.Transparent
            )
        ) {
            Icon(painterResource(R.drawable.ic_back), contentDescription = "Back")
        }
        FavoritesButton(onClick = favoriteClick, isFavorite = isFavorite)
    }
}


@Composable
@Preview(showBackground = true, widthDp = 500, heightDp = 500)
private fun ToolbarPreview() {
    AppTheme {
        Column(
            Modifier
                .height(1900.dp)
                .width(900.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Toolbar(backClick = {}, favoriteClick = {}, isFavorite = true, modifier = Modifier.fillMaxSize())
        }
    }
}

