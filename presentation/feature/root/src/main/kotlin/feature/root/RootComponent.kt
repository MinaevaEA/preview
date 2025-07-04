package feature.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.instancekeeper.retainedInstance
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import feature.main.container.MainContainerComponent
import feature.root.navigation.Child
import feature.root.navigation.Config
import feature.root.ui.RootViewModel
import feature.root.ui.mvi.Action
import feature.root.ui.mvi.State
import presentation.core.decompose.BaseComponent

public class RootComponent
@AssistedInject constructor(
    @Assisted componentContext: ComponentContext,
    @Assisted isAuthorized: Boolean,
    @Assisted initialDeeplink: String?,
    private val mainFactory: MainContainerComponent.Factory
) : BaseComponent(componentContext) {

    internal val viewModel: RootViewModel = retainedInstance {
        RootViewModel(
            initialState = restoreState(State.serializer()) ?: State()
        )
    }

    init {
        initStateSaver(State.serializer()) { viewModel.currentState() }
    }

    private val stackNavigator = StackNavigation<Config>()

    internal fun handleAction(action: Action) {
        // Nothing to do
    }

    internal val stack: Value<ChildStack<*, Child>> = childStack(
        source = stackNavigator,
        initialConfiguration = Config.Main,
        serializer = Config.serializer(),
        handleBackButton = true,
        childFactory = ::childFactory
    )

    private fun childFactory(
        config: Config,
        context: ComponentContext
    ): Child = when(config) {
        is Config.Main -> Child.Main(mainComponent(context))
    }

    private fun mainComponent(
        context: ComponentContext
    ) = mainFactory(context)

    @AssistedFactory
    public fun interface Factory {
        public operator fun invoke(
            componentContext: ComponentContext,
            isAuthorized: Boolean,
            initialDeeplink: String?
        ): RootComponent
    }

}
