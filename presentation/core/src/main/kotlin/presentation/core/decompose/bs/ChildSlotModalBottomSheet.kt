package presentation.core.decompose.bs

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.arkivanov.decompose.router.slot.ChildSlot

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun <C : BaseBottomSheetComponent> ChildSlotModalBottomSheet(
    modifier: Modifier = Modifier,
    slotState: State<ChildSlot<*, C>>,
    shape: Shape = BottomSheetDefaults.ExpandedShape,
    containerColor: Color,
    contentColor: Color = contentColorFor(containerColor),
    tonalElevation: Dp = BottomSheetDefaults.Elevation,
    scrimColor: Color = BottomSheetDefaults.ScrimColor,
    dragHandle: @Composable (() -> Unit)? = null,
    content: @Composable (ColumnScope.(C, () -> Unit) -> Unit),
) {
    val slot by slotState

    ComponentModalBottomSheet(
        component = slot.child?.instance,
        modifier = modifier.statusBarsPadding(),
        shape = shape,
        containerColor = containerColor,
        contentColor = contentColor,
        tonalElevation = tonalElevation,
        scrimColor = scrimColor,
        dragHandle = dragHandle,
        content = content
    )
}
