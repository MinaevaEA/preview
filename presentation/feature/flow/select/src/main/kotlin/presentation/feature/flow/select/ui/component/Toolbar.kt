package presentation.feature.flow.select.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import presentation.resources.R
import presentation.uikit.theme.AppColors
import presentation.uikit.theme.AppTheme
import presentation.uikit.theme.AppTypography

@Composable
internal fun Toolbar(
    backClick: () -> Unit,
) {
    Row{
        IconButton(
            onClick = backClick,
            colors = IconButtonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Unspecified,
                disabledContainerColor = Color.Transparent,
                disabledContentColor = Color.Transparent,
            )
        ) {
            Icon(painterResource(R.drawable.ic_back_white), contentDescription = "Back")
        }
        Text(
            stringResource(R.string.category_list_choose), modifier = Modifier.fillMaxWidth().align(Alignment.CenterVertically),
            color = AppColors.neutral0,
            style = AppTypography.bodyLarge.bold,
            textAlign = TextAlign.Center
        )
    }
}


@Composable
@Preview(showBackground = true, widthDp = 500, heightDp = 500)
private fun ToolbarPreview() {
    AppTheme {
        Column(
            Modifier
                .height(1900.dp)
                .width(900.dp)
                .background(AppColors.neutral90),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Toolbar(backClick = {})
        }
    }
}

