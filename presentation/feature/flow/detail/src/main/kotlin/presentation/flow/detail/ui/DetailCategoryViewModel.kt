package presentation.flow.detail.ui

import presentation.core.ui.BaseViewModel
import presentation.flow.detail.ui.mvi.Action
import presentation.flow.detail.ui.mvi.Intent
import presentation.flow.detail.ui.mvi.State


internal class DetailCategoryViewModel(initialState: State) : BaseViewModel<State, Intent, Action>(initialState) {
    override fun obtainIntent(intent: Intent) {
        when (intent){
            is Intent.onBack -> action = Action.onBackClick
            is Intent.OnDateSelect -> viewState = viewState.changeSelectedDate(intent.date)
        }
    }
}
