package presentation.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import presentation.model.human.CategoryHuman
import presentation.uikit.theme.AppColors
import presentation.uikit.theme.AppTheme
import presentation.uikit.theme.AppTypography
import java.time.LocalDate

@Composable
fun LectureCategory(
    modifier: Modifier = Modifier,
    categoryHuman: CategoryHuman
) {
    Column(
        modifier = modifier
            .clip(shape = RoundedCornerShape(4.dp))
            .background(color = Color(categoryHuman.color))

    ) {
        Text(
            modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp),
            text = categoryHuman.category,
            color = AppColors.neutral0,
            style = AppTypography.bodyMedium.bold,
        )
    }
}

@Composable
@Preview(showBackground = true, widthDp = 500, heightDp = 500)
private fun LectureCategoryView() {
    AppTheme {
        Column(
            Modifier
                .height(1900.dp)
                .width(900.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            LectureCategory(categoryHuman = CategoryHuman.getPreview())
        }
    }
}
