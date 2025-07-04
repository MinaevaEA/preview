package presentation.uikit.component.bs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.router.slot.ChildSlot
import presentation.core.decompose.bs.BaseBottomSheetComponent
import presentation.core.decompose.bs.ChildSlotModalBottomSheet
import presentation.uikit.R
import presentation.uikit.theme.AppColors

@Composable
fun <C : BaseBottomSheetComponent> BottomSheetPrimary(
    slotState: State<ChildSlot<*, C>>,
    content: @Composable ColumnScope.(C, () -> Unit) -> Unit
) {

    ChildSlotModalBottomSheet(
        slotState = slotState,
        containerColor = AppColors.neutral90,
    ) { component, requestDismiss ->
        Toolbar(
            onCloseClick = requestDismiss
        )

        content(component, requestDismiss)
    }

}

@Composable
private fun Toolbar(
    modifier: Modifier = Modifier,
    onCloseClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = 24.dp,
                bottom = 4.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(Modifier.size(48.dp))

        Box(
            modifier = Modifier
                .width(48.dp)
                .height(6.dp)
                .background(
                    shape = RoundedCornerShape(6.dp),
                    color = AppColors.neutral95
                )
        )

        Spacer(Modifier.size(48.dp))
    }
}
