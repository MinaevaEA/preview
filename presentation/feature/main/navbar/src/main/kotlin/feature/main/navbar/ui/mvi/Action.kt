package feature.main.navbar.ui.mvi

import presentation.core.ui.BaseAction
import presentation.model.enums.NavTab

internal sealed interface Action : BaseAction {

    class ChangeTab(val newTab: NavTab) : Action

}
