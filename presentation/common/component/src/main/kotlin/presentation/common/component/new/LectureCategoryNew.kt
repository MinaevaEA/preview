package presentation.common.component.new

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import presentation.common.shape.ParallelogramShape
import presentation.model.human.CategoryHuman
import presentation.uikit.theme.AppColors
import presentation.uikit.theme.AppTheme
import presentation.uikit.theme.typography.secondaryFontFamily

@Composable
fun LectureCategoryNew(
    modifier: Modifier = Modifier,
    category: CategoryHuman
) {
    Text(
        modifier = modifier
            .background(
                color = AppColors.accent0,
                shape = ParallelogramShape(4.dp)
            )
            .padding(horizontal = 10.dp),
        text = category.text,
        fontSize = 14.sp,
        fontWeight = FontWeight.W500,
        fontFamily = secondaryFontFamily,
        color = AppColors.accent20,
    )
}

@Composable
@Preview
private fun LectureCategoryNewPreview() {
    AppTheme {
        LectureCategoryNew(
            category = CategoryHuman.getPreview()
        )
    }
}


