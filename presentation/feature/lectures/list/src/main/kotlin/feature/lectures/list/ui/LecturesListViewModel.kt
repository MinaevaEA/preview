package feature.lectures.list.ui

import feature.lectures.list.ui.mvi.Action
import feature.lectures.list.ui.mvi.Intent
import feature.lectures.list.ui.mvi.State
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import presentation.core.ui.BaseViewModel

internal class LecturesListViewModel(
    initialState: State
) : BaseViewModel<State, Intent, Action>(initialState) {

    override fun obtainIntent(intent: Intent) {
        when(intent) {
            is Intent.OnSelectCategoryClick -> action = Action.SelectCategory()
            is Intent.OnMastermindClick -> action = Action.OpenMastermind()
            is Intent.OnDateSelect -> viewState = viewState.changeSelectedDate(intent.date)
            is Intent.OnRefresh -> loadLectures()
            is Intent.OnLectureClick -> action = Action.OpenLecture(intent.lecture)
            is Intent.OnCategoryClick -> action = Action.OpenCategory(intent.category)
        }
    }

    private fun loadLectures() {
        coroutineScope.launch {
            viewState = viewState.toggleRefreshing(true)
            delay(1000)
            viewState = viewState.toggleRefreshing(false)
        }
    }
}
