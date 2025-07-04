package presentation.feature.flow.select.ui

import presentation.core.ui.BaseViewModel
import presentation.feature.flow.select.mvi.Action
import presentation.feature.flow.select.mvi.Intent
import presentation.feature.flow.select.mvi.State

internal class SelectCategoryViewModel(initialState: State) : BaseViewModel<State, Intent, Action>(initialState) {
    override fun obtainIntent(intent: Intent) {
        when (intent){
            is Intent.onBack -> action = Action.onBackClick
        }
    }
}
