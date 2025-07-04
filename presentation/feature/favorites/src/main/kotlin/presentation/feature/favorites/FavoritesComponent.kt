package presentation.feature.favorites

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.retainedInstance
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import presentation.core.decompose.BaseComponent
import presentation.feature.favorites.ui.FavoritesViewModel
import presentation.feature.favorites.ui.mvi.Action
import presentation.feature.favorites.ui.mvi.State
import presentation.model.human.LectureHuman


public class FavoritesComponent @AssistedInject constructor(
    @Assisted componentContext: ComponentContext,
    @Assisted("open_lecture") private val openLecture: (LectureHuman) -> Unit,
) : BaseComponent(componentContext) {

    internal val viewModel = retainedInstance {
        FavoritesViewModel(
            initialState = restoreState(State.serializer()) ?: State.getPreview()
        )
    }

    init {
        initStateSaver(State.serializer()) { viewModel.currentState() }
    }

    internal fun handleAction(action: Action) {
        when (action) {
            is Action.OpenLecture -> openLecture(action.lectureHuman)
        }
    }

    @AssistedFactory
    public fun interface Factory {
        public operator fun invoke(
            componentContext: ComponentContext,
            @Assisted("open_lecture") openLecture: (LectureHuman) -> Unit,
        ): FavoritesComponent
    }
}
