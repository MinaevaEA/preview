package feature.lectures.detail.ui

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.retainedInstance
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import presentation.core.decompose.BaseComponent
import presentation.model.human.LectureHuman
import feature.lectures.detail.ui.mvi.Action
import feature.lectures.detail.ui.mvi.State

public class DetailLectureComponent @AssistedInject constructor(
    @Assisted componentContext: ComponentContext,
    @Assisted("lecture_detail") private val lectureDetail: LectureHuman,
    @Assisted("on_back") private val onBack: () -> Unit
) : BaseComponent(componentContext) {

    internal val viewModel = retainedInstance {
        DetailLectureViewModel(
            initialState = restoreState(State.serializer()) ?: State.getPreview()
        )
    }

    init {
        initStateSaver(State.serializer()) { viewModel.currentState() }
    }

    internal fun handleAction(action: Action) {
        when(action){
            is Action.onBackClick -> onBack()
        }
    }

    @AssistedFactory
    public fun interface Factory {
        public operator fun invoke(
            componentContext: ComponentContext,
            @Assisted("lecture_detail") lectureDetail: LectureHuman,
            @Assisted("on_back") onBack: () -> Unit
        ): DetailLectureComponent
    }
}
