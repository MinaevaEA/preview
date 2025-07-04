package presentation.feature.flow.select

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.retainedInstance
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import presentation.core.decompose.BaseComponent
import presentation.feature.flow.select.mvi.Action
import presentation.feature.flow.select.mvi.State
import presentation.feature.flow.select.ui.SelectCategoryViewModel

public class SelectCategoryComponent @AssistedInject constructor(
    @Assisted componentContext: ComponentContext,
    @Assisted("save_category") private val onSaveCategory: () -> Unit,
    @Assisted("on_back") private val onBack: () -> Unit
) : BaseComponent(componentContext) {

    internal val viewModel = retainedInstance {
        SelectCategoryViewModel(
            initialState = restoreState(State.serializer()) ?: State.getPreview()
        )
    }

    init {
        initStateSaver(State.serializer()) { viewModel.currentState() }
    }

    internal fun handleAction(action: Action) {
        when(action){
            is Action.onBackClick -> onBack()
            is Action.onSaveCategory -> onSaveCategory()
        }
    }

    @AssistedFactory
    public fun interface Factory {
        public operator fun invoke(
            componentContext: ComponentContext,
            @Assisted("save_category") onSaveCategory: () -> Unit,
            @Assisted("on_back") onBack: () -> Unit
        ): SelectCategoryComponent
    }
}
