package feature.main.container.ui

import feature.main.container.ui.mvi.Action
import feature.main.container.ui.mvi.Intent
import feature.main.container.ui.mvi.State
import presentation.core.ui.BaseViewModel

internal class MainContainerViewModel(
    initialState: State
) : BaseViewModel<State, Intent, Action>(initialState) {

    override fun obtainIntent(intent: Intent) {
        // Nothing to do
    }

}
