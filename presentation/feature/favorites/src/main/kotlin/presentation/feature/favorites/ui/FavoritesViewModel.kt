package presentation.feature.favorites.ui

import presentation.core.ui.BaseViewModel
import presentation.feature.favorites.ui.mvi.Action
import presentation.feature.favorites.ui.mvi.Intent
import presentation.feature.favorites.ui.mvi.State

internal class FavoritesViewModel(initialState: State) : BaseViewModel<State, Intent, Action>(initialState) {
    override fun obtainIntent(intent: Intent) {
        when (intent){
            is Intent.OnDateSelect -> viewState = viewState.changeSelectedDate(intent.date)
            is Intent.OnLectureClick -> action = Action.OpenLecture(intent.lecture)
        }
    }
}
