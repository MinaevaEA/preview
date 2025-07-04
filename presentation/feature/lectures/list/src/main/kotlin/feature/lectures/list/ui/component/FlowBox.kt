package feature.lectures.list.ui.component

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import presentation.uikit.theme.AppColors
import presentation.uikit.theme.AppTheme
import presentation.uikit.theme.AppTypography

@Composable
internal fun FlowBox(
    title: String,
    onClick: () -> Unit,

) {
    Column(
        Modifier
            .padding(end = 7.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .background(AppColors.neutral80)
            .padding(30.dp)
            .clickable { onClick() }
    ) {
        Text(
            modifier = Modifier,
            text = title,
            style = AppTypography.label.bold,
            color = ( AppColors.neutral0),
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
            FlowBox(title = "Задать вопрос", {})
        }
    }
}
