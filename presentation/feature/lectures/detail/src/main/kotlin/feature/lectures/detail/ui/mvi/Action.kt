package feature.lectures.detail.ui.mvi

import presentation.core.ui.BaseAction

internal interface Action : BaseAction {
    object onBackClick: Action
}
