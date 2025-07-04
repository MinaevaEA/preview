package feature.lectures.list

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.retainedInstance
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import feature.lectures.list.ui.LecturesListViewModel
import feature.lectures.list.ui.mvi.Action
import feature.lectures.list.ui.mvi.State
import presentation.core.decompose.BaseComponent
import presentation.model.human.CategoryHuman
import presentation.model.human.LectureHuman

public class LecturesListComponent
@AssistedInject constructor(
    @Assisted componentContext: ComponentContext,
    @Assisted("open_lecture") private val openLecture: (LectureHuman) -> Unit,
    @Assisted("select_category") private val selectCategory: () -> Unit,
    @Assisted("open_category") private val openCategory: (CategoryHuman) -> Unit
) : BaseComponent(componentContext) {

    internal val viewModel = retainedInstance {
        LecturesListViewModel(
            initialState = restoreState(State.serializer()) ?: State.getPreview()
        )
    }

    init {
        initStateSaver(State.serializer()) { viewModel.currentState() }
    }

    internal fun handleAction(action: Action) {
        when (action) {
            is Action.OpenLecture -> openLecture(action.lectureHuman)
            is Action.OpenMastermind -> {}
            is Action.SelectCategory -> selectCategory()
            is Action.OpenCategory -> openCategory(action.categoryHuman)
        }
    }

    @AssistedFactory
    public fun interface Factory {
        public operator fun invoke(
            componentContext: ComponentContext,
            @Assisted("open_lecture") openLecture: (LectureHuman) -> Unit,
            @Assisted("select_category") selectCategory: () -> Unit,
            @Assisted("open_category") openCategory: (CategoryHuman) -> Unit
        ): LecturesListComponent
    }

}
