package presentation.core.decompose.dialog

import com.arkivanov.decompose.ComponentContext
import presentation.core.decompose.BaseComponent

abstract class BaseDialogComponent(
    componentContext: ComponentContext,
    val onTouchOutside: () -> Unit
) : BaseComponent(componentContext) {

    open val dismissOnBackPressed: Boolean = true

}
