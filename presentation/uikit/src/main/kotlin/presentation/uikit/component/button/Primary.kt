package presentation.uikit.component.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import presentation.uikit.theme.AppColors
import presentation.uikit.theme.AppTheme
import presentation.uikit.theme.AppTypography

@Composable
fun ButtonPrimaryBig(
    modifier: Modifier = Modifier.fillMaxWidth(),
    onClick: () -> Unit,
    text: String,
    isEnabled: Boolean = true,
    isLoading: Boolean = false,
) {
    ButtonBase(
        modifier = modifier,
        onClick = onClick,
        text = text,
        contentPadding = PaddingValues(vertical = 16.dp, horizontal = 8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = AppColors.accent20,
            contentColor = AppColors.neutral0,
            disabledContainerColor = if (isLoading) AppColors.accent20 else AppColors.accent0,
            disabledContentColor = AppColors.neutral0,
        ),
        isEnabled = isEnabled,
        isLoading = isLoading,
        textStyle = AppTypography.caption.bold,
        loaderSize = 19.dp,
        radius = 12.dp
    )
}

@Composable
fun ButtonPrimaryMedium(
    modifier: Modifier = Modifier.fillMaxWidth(),
    onClick: () -> Unit,
    text: String,
    isEnabled: Boolean = true,
    isLoading: Boolean = false,
) {
    ButtonBase(
        modifier = modifier,
        onClick = onClick,
        text = text,
        contentPadding = PaddingValues(13.5.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = AppColors.accent20,
            contentColor = AppColors.neutral0,
            disabledContainerColor = if (isLoading) AppColors.accent20 else AppColors.accent0,
            disabledContentColor = AppColors.neutral0,
        ),
        isEnabled = isEnabled,
        isLoading = isLoading,
        textStyle = AppTypography.caption.bold,
        loaderSize = 20.dp,
        radius = 10.dp
    )
}

@Composable
fun ButtonPrimarySmall(
    modifier: Modifier = Modifier.fillMaxWidth(),
    onClick: () -> Unit,
    text: String,
    isEnabled: Boolean = true,
    isLoading: Boolean = false,
) {
    ButtonBase(
        modifier = modifier,
        onClick = onClick,
        text = text,
        contentPadding = PaddingValues(6.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = AppColors.accent20,
            contentColor = AppColors.neutral0,
            disabledContainerColor = if (isLoading) AppColors.accent20 else AppColors.accent0,
            disabledContentColor = AppColors.neutral0,
        ),
        isEnabled = isEnabled,
        isLoading = isLoading,
        textStyle = AppTypography.caption.bold,
        loaderSize = 19.dp,
        radius = 8.dp
    )
}

@Composable
fun ButtonRoundedBase(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    iconId: Int,
    iconSize: Dp = 24.dp,
    enabled: Boolean = true,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = AppColors.accent20,
            contentColor = AppColors.neutral0,
            disabledContainerColor = AppColors.accent20,
            disabledContentColor = AppColors.neutral0,
        ),
    ) {
        Icon(
            modifier = Modifier.size(iconSize),
            painter = painterResource(iconId),
            contentDescription = "",
            tint = Color.Unspecified
        )
    }
}

@Composable
@Preview(showBackground = true, widthDp = 1000)
private fun PrimaryButtonsPreview() {
    AppTheme {
        Row {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                ButtonPrimaryBig(onClick = {}, text = "Big Button")
                ButtonPrimaryMedium(onClick = {}, text = "Medium Button")
                ButtonPrimarySmall(onClick = {}, text = "Small Button")
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                ButtonPrimaryBig(onClick = {}, text = "Big Button", isEnabled = false)
                ButtonPrimaryMedium(onClick = {}, text = "Medium Button", isEnabled = false)
                ButtonPrimarySmall(onClick = {}, text = "Small Button", isEnabled = false)
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                ButtonPrimaryBig(onClick = {}, text = "Big Button", isLoading = true)
                ButtonPrimaryMedium(onClick = {}, text = "Medium Button", isLoading = true)
                ButtonPrimarySmall(onClick = {}, text = "Small Button", isLoading = true)
                ButtonRoundedBase(onClick = { /*TODO*/ }, iconId = 0 )
            }
        }
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFF000000, widthDp = 1000)
private fun PrimaryButtonsDarkPreview() {
    AppTheme(true) {
        Row {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                ButtonPrimaryBig(onClick = {}, text = "Big Button")
                ButtonPrimaryMedium(onClick = {}, text = "Medium Button")
                ButtonPrimarySmall(onClick = {}, text = "Small Button")
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                ButtonPrimaryBig(onClick = {}, text = "Big Button", isEnabled = false)
                ButtonPrimaryMedium(onClick = {}, text = "Medium Button", isEnabled = false)
                ButtonPrimarySmall(onClick = {}, text = "Small Button", isEnabled = false)
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                ButtonPrimaryBig(onClick = {}, text = "Big Button", isLoading = true)
                ButtonPrimaryMedium(onClick = {}, text = "Medium Button", isLoading = true)
                ButtonPrimarySmall(onClick = {}, text = "Small Button", isLoading = true)
            }
        }
    }
}
