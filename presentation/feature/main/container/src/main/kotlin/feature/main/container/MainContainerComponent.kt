package feature.main.container

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.instancekeeper.retainedInstance
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import feature.lectures.detail.ui.DetailLectureComponent
import feature.main.container.navigation.Child
import feature.main.container.navigation.Config
import feature.main.container.ui.MainContainerViewModel
import feature.main.container.ui.mvi.Action
import feature.main.container.ui.mvi.State
import feature.main.navbar.NavBarComponent
import presentation.core.decompose.BaseComponent
import presentation.feature.category.detail.ui.DetailCategoryComponent
import presentation.feature.category.select.SelectCategoryComponent
import presentation.model.enums.NavTab

public class MainContainerComponent
@AssistedInject constructor(
    @Assisted componentContext: ComponentContext,
    private val navBarFactory: NavBarComponent.Factory,
    private val lectureDetailFactory: DetailLectureComponent.Factory,
    private val selectCategoryFactory: SelectCategoryComponent.Factory,
    private val categoryDetailFactory: DetailCategoryComponent.Factory
) : BaseComponent(componentContext) {

    internal val viewModel = retainedInstance {
        MainContainerViewModel(
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
        initialConfiguration = Config.NavBar(initialTab = NavTab.LECTURES),
        serializer = Config.serializer(),
        handleBackButton = true,
        childFactory = ::childFactory
    )

    private fun childFactory(
        config: Config,
        context: ComponentContext
    ): Child = when (config) {
        is Config.NavBar -> Child.NavBar(navBarComponent(config, context))
        is Config.LectureDetail -> Child.LectureDetail(lectureDetailComponent(config, context))
        is Config.SelectCategory -> Child.SelectCategory(selectCategoryComponent(context))
        is Config.CategoryDetail -> Child.OpenCategory(categoryDetailComponent(config, context))
    }

    private fun navBarComponent(
        config: Config.NavBar,
        context: ComponentContext
    ) = navBarFactory(
        componentContext = context,
        initialTab = config.initialTab,
        openLecture = { stackNavigator.pushNew(Config.LectureDetail(it)) },
        selectCategory = { stackNavigator.pushNew(Config.SelectCategory) },
        openCategory = { stackNavigator.pushNew(Config.CategoryDetail(it)) }
    )

    private fun categoryDetailComponent(
        config: Config.CategoryDetail,
        context: ComponentContext
    ) = categoryDetailFactory(context,
        onBack = { stackNavigator.pop() })

    private fun lectureDetailComponent(
        config: Config.LectureDetail,
        context: ComponentContext
    ) = lectureDetailFactory(context, config.lecture, onBack = { stackNavigator.pop() })

    private fun selectCategoryComponent(
        context: ComponentContext
    ) = selectCategoryFactory(context,
        onBack = { stackNavigator.pop() },
        onSaveCategory = {})

    public fun onLectureSelected(lecture: String) {}

    @AssistedFactory
    public fun interface Factory {
        public operator fun invoke(
            componentContext: ComponentContext
        ): MainContainerComponent
    }
}

