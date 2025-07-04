package feature.main.navbar.ui

import feature.main.navbar.ui.mvi.Action
import feature.main.navbar.ui.mvi.Intent
import feature.main.navbar.ui.mvi.State
import presentation.core.ui.BaseViewModel

internal class NavBarViewModel(
    initialState: State
) : BaseViewModel<State, Intent, Action>(initialState) {

    override fun obtainIntent(intent: Intent) {
        when(intent) {
            is Intent.OnTabClick -> action = Action.ChangeTab(intent.tab)
            is Intent.OnTabChanged -> viewState = viewState.changeCurrentTab(intent.newTab)
        }
    }

}
