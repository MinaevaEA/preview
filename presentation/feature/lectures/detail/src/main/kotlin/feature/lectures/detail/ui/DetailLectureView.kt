package feature.lectures.detail.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import presentation.model.human.CategoryHuman
import presentation.model.human.LectureHuman
import presentation.resources.R
import presentation.uikit.component.button.ButtonPrimaryBig
import presentation.uikit.theme.AppColors
import presentation.uikit.theme.AppTheme
import presentation.uikit.theme.AppTypography
import feature.lectures.detail.ui.component.BigImage
import feature.lectures.detail.ui.component.ItemLectureSpeaker
import feature.lectures.detail.ui.mvi.Intent
import feature.lectures.detail.ui.mvi.State

@Composable
internal fun DetailLectureView(
    state: State,
    intentConsumer: (Intent) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.neutral100)
            .navigationBarsPadding(),
    ) {
        LazyColumn {
            item {
                Column {
                    BigImage(
                        image = state.lectureHuman.photo,
                        categoryHuman = state.categoryHuman,
                        onBackClick = { intentConsumer(Intent.onBack) },
                        onFavoriteClick = { intentConsumer(Intent.onFavorite) },
                        isFavorite = state.isFavorite,
                        lectureHuman = state.lectureHuman
                    )

                    Text(
                        modifier = Modifier.padding(16.dp), text = state.lectureHuman.description,
                        style = AppTypography.bodyMedium.regular,
                        color = AppColors.neutral0,
                    )
                    ItemLectureSpeaker(state.lectureHuman)
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            ButtonPrimaryBig(
                modifier = Modifier
                    .padding(12.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(AppColors.accent20)
                    .padding(start = 12.dp, end = 12.dp),
                text = stringResource(R.string.lection_question),
                onClick = { intentConsumer(Intent.onClickQuestion) },
                isEnabled = true,
                isLoading = false
            )
        }
    }
}


@Composable
@Preview(showBackground = true)
private fun DetailLectureViewPreview() {
    AppTheme {
        Column(
            Modifier
                .height(1900.dp)
                .width(900.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            DetailLectureView(State(LectureHuman.getPreview(), CategoryHuman.getPreview(), false), {})
        }
    }
}
