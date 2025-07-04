package feature.lectures.list.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import presentation.uikit.theme.AppColors
import presentation.uikit.theme.AppTheme
import presentation.resources.R
import presentation.uikit.component.button.ButtonPrimaryMedium
import presentation.uikit.theme.AppTypography

@Composable
internal fun MastermindBanner(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit
) {
    Box(
        modifier = modifier.fillMaxWidth()
            .height(136.dp)
    ) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop,
            painter = painterResource(R.drawable.img_banner_main),
            contentDescription = "Mastermind banner"
        )

        Row(
            modifier = Modifier.fillMaxSize()
                .padding(vertical = 10.dp, horizontal = 12.dp)
        ) {
            Text(
                modifier = Modifier
                    .padding(top = 14.dp)
                    .fillMaxWidth(0.5f),
                text = stringResource(R.string.lectures_list_mastermind_title),
                style = AppTypography.label.bold,
                color = AppColors.neutral0
            )

            Box(
                modifier = Modifier.fillMaxWidth()
                    .fillMaxHeight(),
                contentAlignment = Alignment.BottomEnd
            ) {
                ButtonPrimaryMedium(
                    modifier = Modifier,
                    onClick = onButtonClick,
                    text = stringResource(R.string.lectures_list_mastermind_join)
                )
            }
        }
    }
}

@Composable
@Preview
private fun MastermindBannerPreview() {
    AppTheme {
        Box(Modifier.fillMaxWidth().background(AppColors.neutral95)) {
            MastermindBanner(
                onButtonClick = {}
            )
        }
    }
}
