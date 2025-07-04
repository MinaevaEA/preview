package presentation.feature.flow.select.mvi

import presentation.core.ui.BaseAction

internal interface Action : BaseAction {

    object onBackClick: Action

    data class onSaveCategory(val category: List<String>) : Action
}
