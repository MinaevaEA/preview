package presentation.common.component.new

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import presentation.common.component.LectureCard
import presentation.model.human.LectureHuman
import presentation.model.human.SpeakerHuman
import presentation.uikit.theme.AppTheme
import presentation.uikit.theme.typography.secondaryFontFamily
import presentation.resources.R
import presentation.uikit.theme.AppColors
import presentation.uikit.theme.typography.primaryFontFamily

@Composable
fun LectureCardNew(
    modifier: Modifier = Modifier,
    lecture: LectureHuman,
    onClick: () -> Unit,
    onFavoriteClick: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            LectureCategoryNew(
                category = lecture.category
            )

            FavoritesButtonNew(
                isFavorite = lecture.isFavorite,
                onClick = onFavoriteClick
            )
        }

        Text(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
            text = lecture.title,
            fontSize = 16.sp,
            fontWeight = FontWeight.W600,
            fontFamily = secondaryFontFamily,
            color = AppColors.neutral90
        )

        Spacer(
            modifier = Modifier.height(4.dp)
        )

        lecture.speakers.forEach { speaker ->
            LectureSpeaker(
                modifier = Modifier.padding(top = 8.dp),
                speaker = speaker
            )
        }
    }
}

@Composable
private fun LectureSpeaker(
    modifier: Modifier = Modifier,
    speaker: SpeakerHuman
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        AsyncImage(
            modifier = Modifier.width(77.dp)
                .height(40.dp),
            model = speaker.photo,
            contentDescription = "speaker",
            placeholder = painterResource(R.drawable.ic_speaker_placeholder)
        )

        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = speaker.name,
                fontSize = 13.sp,
                fontWeight = FontWeight.W600,
                fontFamily = primaryFontFamily,
                color = AppColors.neutral90
            )

            Text(
                text = speaker.appointment,
                fontSize = 13.sp,
                fontWeight = FontWeight.W400,
                fontFamily = secondaryFontFamily,
                color = AppColors.neutral80
            )
        }
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
private fun LectureCardPreview() {
    AppTheme {
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(16.dp)
        ) {
            LectureCardNew(
                lecture = LectureHuman.getPreview(),
                onClick = {},
                onFavoriteClick = {}
            )
        }
    }
}
