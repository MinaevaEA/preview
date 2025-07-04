package presentation.feature.category.select.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import presentation.feature.category.select.mvi.enum.TypeSelect
import presentation.uikit.theme.AppColors
import presentation.uikit.theme.AppTheme
import presentation.uikit.theme.AppTypography

@Composable
internal fun CategoryItem(
    title: String,
    onClick: () -> Unit,
    typeSelected: TypeSelect,
) {
    Column(
        Modifier
            .padding(7.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .clickable { onClick() }
            .background(
                when (typeSelected) {
                    TypeSelect.DEFAULT -> AppColors.accent10
                    TypeSelect.SELECTED -> AppColors.accent60
                    TypeSelect.NONE -> AppColors.neutral80
                }
            )
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier,
            text = title,
            style = AppTypography.label.bold,
            color = when (typeSelected) {
                TypeSelect.DEFAULT -> AppColors.neutral100
                TypeSelect.SELECTED -> AppColors.neutral0
                TypeSelect.NONE -> AppColors.neutral0
            },
            textAlign = TextAlign.Center
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun ButtonBoxPreview() {
    AppTheme {
        Column(
            Modifier
                .height(900.dp)
                .width(900.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            CategoryItem(title = "Дизайн", {}, TypeSelect.SELECTED)
        }
    }
}
