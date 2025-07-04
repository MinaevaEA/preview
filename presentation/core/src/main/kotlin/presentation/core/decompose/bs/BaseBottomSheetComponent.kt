package presentation.core.decompose.bs

import com.arkivanov.decompose.ComponentContext
import presentation.core.decompose.BaseComponent

abstract class BaseBottomSheetComponent(
    componentContext: ComponentContext,
    val onBottomSheetDismissed: () -> Unit
) : BaseComponent(componentContext) {

    open val isClosable: Boolean = true

    open val dismissOnBackPressed: Boolean = true

}
