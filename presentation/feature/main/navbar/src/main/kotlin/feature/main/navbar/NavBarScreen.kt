package feature.main.navbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import feature.lectures.list.LecturesListScreen
import feature.main.navbar.navigation.Child
import feature.main.navbar.ui.NavBarView
import presentation.core.decompose.ui.NavigationHolder
import presentation.core.screen.MVIScreen
import presentation.feature.favorites.FavoritesScreen

@Composable
public fun NavBarScreen(component: NavBarComponent) {
    MVIScreen(
        viewModel = component.viewModel,
        handleAction = component::handleAction
    ) { state, intentConsumer ->
        NavBarView(state, intentConsumer) {
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
        is Child.Lectures -> LecturesListScreen(child.component)
        is Child.Favorites -> FavoritesScreen(child.component)
        is Child.Partners -> Box(Modifier.fillMaxSize().background(Color.Blue))
        is Child.About -> Box(Modifier.fillMaxSize().background(Color.Yellow))
    }
}
