package presentation.core.decompose.dialog

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.router.slot.ChildSlot

@Composable
fun <C : BaseDialogComponent> ChildSlotAlertDialog(
    slotState: State<ChildSlot<*, C>>,
    shape: Shape = RoundedCornerShape(24.dp),
    content: @Composable (C) -> Unit
) {
    val slot by slotState

    ComponentAlertDialog(
        component = slot.child?.instance,
        shape = shape,
        content = content
    )
}
