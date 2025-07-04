package feature.main.container

import androidx.compose.runtime.Composable
import feature.lectures.detail.ui.DetailLecturesScreen
import feature.main.container.navigation.Child
import feature.main.container.ui.MainContainerView
import feature.main.navbar.NavBarScreen
import presentation.core.decompose.ui.NavigationHolder
import presentation.core.screen.MVIScreen
import presentation.feature.category.detail.DetailCategoryScreen
import presentation.feature.category.select.SelectCategoryScreen

@Composable
public fun MainContainerScreen(component: MainContainerComponent) {
    MVIScreen(
        viewModel = component.viewModel,
        handleAction = component::handleAction,
    ) { state, intentConsumer ->
        MainContainerView(state, intentConsumer) {
            NavigationHolder(
                stack = component.stack
            ) { child ->
                ChildrenBuilder(child)
            }
        }
    }
}

@Composable
private fun ChildrenBuilder(child: Child) {
    when(child) {
        is Child.NavBar -> NavBarScreen(child.component)
        is Child.LectureDetail -> DetailLecturesScreen(child.component)
        is Child.SelectCategory -> SelectCategoryScreen(child.component)
        is Child.OpenCategory -> DetailCategoryScreen(child.component)
    }
}
