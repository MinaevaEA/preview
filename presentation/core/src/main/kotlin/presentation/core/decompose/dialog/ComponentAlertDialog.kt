package presentation.core.decompose.dialog

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
internal fun <C : BaseDialogComponent> ComponentAlertDialog(
    component: C?,
    shape: Shape,
    content: @Composable (C) -> Unit
) {
    if (component != null) {
        Dialog(
            onDismissRequest = { component.onTouchOutside() },
            properties = DialogProperties(
                dismissOnBackPress = component.dismissOnBackPressed
            )
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = shape
            ) {
                content(component)
            }
        }
    }
}
