package presentation.core.decompose.bs

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalBottomSheetProperties
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun <C : BaseBottomSheetComponent> ComponentModalBottomSheet(
    modifier: Modifier = Modifier,
    component: C?,
    sheetMaxWidth: Dp = BottomSheetDefaults.SheetMaxWidth,
    shape: Shape = BottomSheetDefaults.ExpandedShape,
    containerColor: Color = BottomSheetDefaults.ContainerColor,
    contentColor: Color = contentColorFor(containerColor),
    tonalElevation: Dp = BottomSheetDefaults.Elevation,
    scrimColor: Color = BottomSheetDefaults.ScrimColor,
    dragHandle: @Composable (() -> Unit)? = null,
    content: @Composable (ColumnScope.(instance: C, () -> Unit) -> Unit)
) {
    val coroutineScope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
    )

    component?.let { instance ->
        ModalBottomSheet(
            onDismissRequest = {
                instance.onBottomSheetDismissed()
            },
            modifier = modifier,
            sheetState = sheetState,
            sheetGesturesEnabled = instance.isClosable,
            sheetMaxWidth = sheetMaxWidth,
            shape = shape,
            containerColor = containerColor,
            contentColor = contentColor,
            tonalElevation = tonalElevation,
            scrimColor = scrimColor,
            dragHandle = dragHandle,
            properties = ModalBottomSheetProperties(
                shouldDismissOnBackPress = instance.dismissOnBackPressed,
                isAppearanceLightNavigationBars = false
            ),
            contentWindowInsets = { WindowInsets(0.dp) },
            content = {
                content(instance) {
                    coroutineScope.launch { sheetState.hide() }
                        .invokeOnCompletion { instance.onBottomSheetDismissed() }
                }
            }
        )
    }
}
