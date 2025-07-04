package feature.main.navbar

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.instancekeeper.retainedInstance
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import feature.lectures.list.LecturesListComponent
import feature.main.navbar.navigation.Child
import feature.main.navbar.navigation.Config
import feature.main.navbar.ui.NavBarViewModel
import feature.main.navbar.ui.mvi.Action
import feature.main.navbar.ui.mvi.Intent
import feature.main.navbar.ui.mvi.State
import presentation.core.decompose.BaseComponent
import presentation.feature.favorites.FavoritesComponent
import presentation.model.enums.NavTab
import presentation.model.human.CategoryHuman
import presentation.model.human.LectureHuman

public class NavBarComponent
@AssistedInject constructor(
    @Assisted componentContext: ComponentContext,
    @Assisted initialTab: NavTab,
    @Assisted("open_lecture") private val openLecture: (LectureHuman) -> Unit,
    @Assisted("select_category") private val selectCategory: () -> Unit,
    @Assisted("open_category") private val openCategory: (CategoryHuman) -> Unit,
    private val lecturesFactory: LecturesListComponent.Factory,
    private val favoritesFactory: FavoritesComponent.Factory,
) : BaseComponent(componentContext) {

    internal val viewModel = retainedInstance {
        NavBarViewModel(
            initialState = restoreState(State.serializer()) ?: State()
        )
    }

    init {
        initStateSaver(State.serializer()) { viewModel.currentState() }
    }

    private val stackNavigator = StackNavigation<Config>()

    internal fun handleAction(action: Action) {
        when (action) {
            is Action.ChangeTab -> changeTab(action.newTab)
        }
    }

    private fun changeTab(newTab: NavTab) {
        stackNavigator.bringToFront(Config.fromTab(newTab)) {
            viewModel.obtainIntent(Intent.OnTabChanged(newTab))
        }
    }

    internal val stack: Value<ChildStack<*, Child>> = childStack(
        source = stackNavigator,
        initialConfiguration = Config.fromTab(initialTab),
        serializer = Config.serializer(),
        handleBackButton = false,
        childFactory = ::childFactory
    )

    private fun childFactory(
        config: Config,
        context: ComponentContext
    ): Child = when (config) {
        is Config.Lectures -> Child.Lectures(lecturesComponent(context))
        is Config.Favorites -> Child.Favorites(favoritesComponent(context))
        is Config.Partners -> Child.Partners(partnersComponent(context))
        is Config.About -> Child.About(aboutComponent(context))
    }

    private fun lecturesComponent(
        context: ComponentContext
    ) = lecturesFactory(
        componentContext = context,
        openLecture = { openLecture(it) },
        selectCategory = { selectCategory() },
        openCategory = { openCategory(it) }
    )

    private fun favoritesComponent(
        context: ComponentContext
    ) = favoritesFactory(
        componentContext = context,
        openLecture = { openLecture(it) }
    )

    private fun partnersComponent(
        context: ComponentContext
    ) = "TODO"

    private fun aboutComponent(
        context: ComponentContext
    ) = "TODO"

    @AssistedFactory
    public fun interface Factory {
        public operator fun invoke(
            componentContext: ComponentContext,
            initialTab: NavTab,
            @Assisted("open_lecture") openLecture: (LectureHuman) -> Unit,
            @Assisted("select_category") selectCategory: () -> Unit,
            @Assisted("open_category") openCategory: (CategoryHuman) -> Unit
        ): NavBarComponent
    }

}
