package feature.root.ui

import feature.root.ui.mvi.Action
import feature.root.ui.mvi.Intent
import feature.root.ui.mvi.State
import presentation.core.ui.BaseViewModel

internal class RootViewModel(
    initialState: State
) : BaseViewModel<State, Intent, Action>(initialState) {

    override fun obtainIntent(intent: Intent) {
        // Nothing to do
    }

}
