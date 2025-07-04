package presentation.feature.category.detail.ui.mvi

import presentation.core.ui.BaseAction

internal interface Action : BaseAction {

    object onBackClick : Action
}
