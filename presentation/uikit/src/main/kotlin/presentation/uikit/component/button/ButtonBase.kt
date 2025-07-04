package presentation.uikit.component.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ButtonBase(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    contentPadding: PaddingValues,
    border: BorderStroke? = null,
    colors: ButtonColors,
    isEnabled: Boolean,
    isLoading: Boolean,
    textStyle: TextStyle,
    loaderSize: Dp,
    radius: Dp
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        enabled = isEnabled && !isLoading,
        shape = RoundedCornerShape(radius),
        border = border,
        contentPadding = contentPadding,
        colors = colors,
        elevation = null
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                color = colors.contentColor,
                modifier = Modifier.size(loaderSize)
            )
        } else {
            Text(
                modifier = Modifier,
                text = text,
                style = textStyle
            )
        }
    }
}
