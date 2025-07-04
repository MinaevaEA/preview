package presentation.flow.detail.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import presentation.common.component.CategoryLecture
import presentation.model.human.CategoryHuman
import presentation.model.human.LectureHuman
import presentation.uikit.theme.AppColors
import presentation.uikit.theme.AppTheme
import presentation.uikit.theme.AppTypography

@Composable
internal fun BigImageCategory(
    image: String,
    categoryHuman: CategoryHuman,
    onBackClick: () -> Unit,
) {
    Column {
        Box(modifier = Modifier.height((233.dp))) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current).data(image).crossfade(true).build(),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(AppColors.neutral70)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Toolbar(
                    backClick = onBackClick,
                    modifier = Modifier.statusBarsPadding()
                )

                Text(
                    modifier = Modifier
                        .padding(start = 16.dp),
                    text = categoryHuman.text,
                    style = AppTypography.bodyXLarge.bold,
                    color = AppColors.neutral0,
                    textAlign = TextAlign.Start
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 51.dp, start = 16.dp, end = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun BigImagePreview() {
    AppTheme {
        Column(
            Modifier
                .height(900.dp)
                .width(900.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            BigImageCategory("", CategoryHuman.getPreview(), {})
        }
    }
}
