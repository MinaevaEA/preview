package presentation.uikit.component.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import presentation.uikit.theme.AppColors
import presentation.uikit.theme.AppTypography

@Composable
fun ButtonSecondarySmall(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    isEnabled: Boolean = true,
    isLoading: Boolean = false,
) {
    ButtonBase(
        modifier = modifier,
        onClick = onClick,
        text = text,
        contentPadding = PaddingValues(vertical = 0.dp, horizontal = 13.dp),
        border = BorderStroke(width = 1.dp, color = AppColors.neutral40),
        colors = ButtonColors(
            containerColor = Color.Transparent,
            contentColor = AppColors.neutral0,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = AppColors.neutral40
        ),
        isEnabled = isEnabled,
        isLoading = isLoading,
        textStyle = AppTypography.caption.medium,
        loaderSize = 20.dp,
        radius = 6.dp
    )
}
