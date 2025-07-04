package feature.lectures.detail.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import presentation.model.human.LectureHuman
import presentation.resources.R
import presentation.uikit.theme.AppColors
import presentation.uikit.theme.AppTheme
import presentation.uikit.theme.AppTypography

@Composable
public fun ItemLectureSpeaker(
    lecture: LectureHuman,
) {
    Column(
        modifier = Modifier
            .padding(top = 2.dp, bottom = 4.dp, start = 17.dp, end = 17.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .background(color = AppColors.neutral90)
            .padding(12.dp)

    ) {
        Column(
            modifier = Modifier
        ) {
            Text(
                text = if (lecture.speakers.size > 1) stringResource(R.string.speaker_list) else stringResource(R.string.speaker_one),
                color = AppColors.neutral0,
                style = AppTypography.label.bold
            )
            Column {
               lecture.speakers.forEach { speaker ->
                    ItemSpeaker(
                        photo = speaker.photo,
                        name = speaker.name,
                        logoCompany = speaker.logoCompany,
                        appointment = speaker.appointment
                    )
                }
            }
        }
    }
}


@Composable
internal fun ItemSpeaker(
    photo: String,
    name: String,
    logoCompany: String,
    appointment: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 11.dp), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(32.dp))
                .background(color = AppColors.neutral0)
        ) {
            Image(photo)
        }
        Column(
            modifier = Modifier.weight(1f, fill = true)
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = name,
                color = AppColors.neutral0,
                style = AppTypography.label.medium,
                textAlign = TextAlign.Start
            )
            Text(
                text = appointment,
                color = AppColors.neutral10,
                style = AppTypography.caption.regular,
                textAlign = TextAlign.Start
            )
        }
        Column(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(32.dp))
                .background(color = AppColors.neutral0)
        ) {
            Image(logoCompany)
        }
    }
}


@Composable
private fun Image(image: String) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current).data(image).crossfade(true).build(),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .clip(shape = RoundedCornerShape(32.dp))
            .size(32.dp)
            .background(AppColors.neutral0)
    )
}

@Composable
@Preview(showBackground = true, widthDp = 500, heightDp = 500)
private fun ItemLectureSpeakerPreview() {
    AppTheme {
        Column(
            Modifier
                .height(1900.dp)
                .width(900.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            ItemLectureSpeaker(LectureHuman.getPreview())
        }
    }
}

