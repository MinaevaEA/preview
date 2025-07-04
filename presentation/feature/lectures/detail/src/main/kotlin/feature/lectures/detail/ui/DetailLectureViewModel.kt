package feature.lectures.detail.ui

import presentation.core.ui.BaseViewModel
import feature.lectures.detail.ui.mvi.Action
import feature.lectures.detail.ui.mvi.Intent
import feature.lectures.detail.ui.mvi.State

internal class DetailLectureViewModel(initialState: State) : BaseViewModel<State, Intent, Action>(initialState) {

    override fun obtainIntent(intent: Intent) {
        when (intent) {
            is Intent.onFavorite -> {}
            is Intent.onBack -> action = Action.onBackClick
            is Intent.onClickQuestion -> {}
        }
    }
}
