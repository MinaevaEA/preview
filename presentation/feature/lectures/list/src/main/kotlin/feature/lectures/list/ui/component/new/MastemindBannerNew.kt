package feature.lectures.list.ui.component.new

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import presentation.model.human.EventHuman
import presentation.uikit.theme.AppTheme
import presentation.resources.R
import presentation.uikit.component.button.ButtonPrimarySmall
import presentation.uikit.theme.AppColors
import presentation.uikit.theme.typography.AppFont
import presentation.uikit.theme.typography.primaryFontFamily

internal const val MASTERMIND_HEIGHT = 330
internal const val LOGO_HEIGHT = 26

@Composable
internal fun MastermindBannerNew(
    modifier: Modifier = Modifier,
    event: EventHuman,
    opacity: Float,
    onDetailClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(MASTERMIND_HEIGHT.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.img_banner_main),
            contentDescription = "mastermind banner",
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier.fillMaxSize()
                .alpha(opacity)
                .background(AppColors.accent20)
        )

        Column(
            modifier = Modifier
                .padding(bottom = 24.dp)
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 8.dp)
                .statusBarsPadding(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                Icon(
                    modifier = Modifier.height(LOGO_HEIGHT.dp),
                    painter = painterResource(R.drawable.ic_logo_header),
                    contentDescription = "logo",
                    tint = AppColors.neutral0
                )

                Text(
                    text = event.rememberDatesRange(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W700,
                    fontFamily = primaryFontFamily,
                    fontStyle = FontStyle.Italic,
                    color = AppColors.neutral0
                )
            }

            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = stringResource(R.string.lectures_list_mastermind_title),
                fontSize = 26.sp,
                fontWeight = FontWeight.W800,
                color = AppColors.neutral0,
                fontFamily = primaryFontFamily,
                textAlign = TextAlign.Center
            )

            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = stringResource(R.string.lectures_list_mastermind_description),
                fontSize = 16.sp,
                fontWeight = FontWeight.W800,
                color = AppColors.neutral0,
                textAlign = TextAlign.Center
            )

            ButtonPrimarySmall(
                modifier = Modifier.padding(top = 16.dp)
                    .width(236.dp),
                text = stringResource(R.string.lectures_list_mastermind_join),
                onClick = onDetailClick
            )
        }
    }
}

@Composable
@Preview
private fun MastermindBannerNewPreview() {
    AppTheme {
        MastermindBannerNew(
            event = EventHuman.getPreview(),
            opacity = 0f,
            onDetailClick = {}
        )
    }
}
