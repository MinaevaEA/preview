package presentation.feature.category.detail.ui

import presentation.core.ui.BaseViewModel
import presentation.feature.category.detail.ui.mvi.Action
import presentation.feature.category.detail.ui.mvi.Intent
import presentation.feature.category.detail.ui.mvi.State


internal class DetailCategoryViewModel(initialState: State) : BaseViewModel<State, Intent, Action>(initialState) {
    override fun obtainIntent(intent: Intent) {
        when (intent){
            is Intent.onBack -> action = Action.onBackClick
            is Intent.OnDateSelect -> viewState = viewState.changeSelectedDate(intent.date)
        }
    }
}
