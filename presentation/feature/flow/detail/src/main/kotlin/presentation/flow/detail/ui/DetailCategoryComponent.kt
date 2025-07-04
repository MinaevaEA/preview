package presentation.flow.detail.ui

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.retainedInstance
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import presentation.core.decompose.BaseComponent
import presentation.flow.detail.ui.mvi.Action
import presentation.flow.detail.ui.mvi.State

public class DetailCategoryComponent @AssistedInject constructor(
    @Assisted componentContext: ComponentContext,
    @Assisted("on_back") private val onBack: () -> Unit
) : BaseComponent(componentContext) {

    internal val viewModel = retainedInstance {
        DetailCategoryViewModel(
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
            @Assisted("on_back") onBack: () -> Unit
        ): DetailCategoryComponent
    }
}
