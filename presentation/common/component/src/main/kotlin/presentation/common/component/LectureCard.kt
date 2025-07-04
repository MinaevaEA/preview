package presentation.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import presentation.model.human.LectureHuman
import presentation.model.human.SpeakerHuman
import presentation.uikit.theme.AppColors
import presentation.uikit.theme.AppTheme
import presentation.uikit.theme.AppTypography

@Composable
fun LectureCard(
    modifier: Modifier = Modifier,
    lecture: LectureHuman,
    onClick: () -> Unit,
    onFavoriteClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .clip(RoundedCornerShape(10.dp))
            .clickable { onClick() }
            .background(AppColors.neutral90)
            .padding(start = 12.dp, top = 12.dp, end = 4.dp, bottom = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(0.7f)
            .padding(bottom = 8.dp)
        ) {
            Text(
                text = lecture.rememberTime(),
                style = AppTypography.caption.semibold,
                color = AppColors.neutral10
            )

            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = lecture.title,
                style = AppTypography.bodyLarge.semibold,
                color = AppColors.neutral0
            )

            lecture.speakers.forEach { speaker ->
                LectureSpeaker(
                    modifier = Modifier.padding(top = 12.dp),
                    speaker = speaker
                )
            }
        }

        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            LectureCategory(
                categoryHuman = lecture.category, modifier = Modifier
            )

            FavoritesButton(
                isFavorite = lecture.isFavorite,
                onClick = onFavoriteClick
            )
        }
    }
}

@Composable
private fun LectureSpeaker(
    modifier: Modifier = Modifier,
    speaker: SpeakerHuman,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Box(
            modifier = Modifier.size(34.dp)
        ) {
            AsyncImage(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(AppColors.neutral20),
                model = speaker.photo,
                contentDescription = "speaker photo",
                contentScale = ContentScale.Crop,
            )

            AsyncImage(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(16.dp)
                    .clip(CircleShape)
                    .background(AppColors.neutral10),
                model = speaker.logoCompany,
                contentDescription = "speaker company logo",
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            Text(
                text = speaker.name,
                style = AppTypography.label.medium,
                color = AppColors.neutral0
            )

            Text(
                text = speaker.appointment,
                style = AppTypography.caption.regular,
                color = AppColors.neutral10
            )
        }
    }
}

@Composable
@Preview
private fun LectureCardPreview() {
    var lecture by remember { mutableStateOf(LectureHuman.getPreview()) }

    AppTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(AppColors.neutral95)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            LectureCard(
                lecture = lecture,
                onClick = {},
                onFavoriteClick = { lecture = lecture.toggleFavorite() }
            )
        }
    }
}
