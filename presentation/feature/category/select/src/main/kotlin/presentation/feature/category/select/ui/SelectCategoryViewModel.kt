package presentation.feature.category.select.ui

import presentation.core.ui.BaseViewModel
import presentation.feature.category.select.mvi.Action
import presentation.feature.category.select.mvi.Intent
import presentation.feature.category.select.mvi.State

internal class SelectCategoryViewModel(initialState: State) : BaseViewModel<State, Intent, Action>(initialState) {
    override fun obtainIntent(intent: Intent) {
        when (intent){
            is Intent.onBack -> action = Action.onBackClick
        }
    }
}
