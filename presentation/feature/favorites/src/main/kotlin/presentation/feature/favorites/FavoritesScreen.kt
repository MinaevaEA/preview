package presentation.feature.favorites

import androidx.compose.runtime.Composable
import presentation.core.screen.MVIScreen
import presentation.feature.favorites.ui.FavoritesView

@Composable
public fun FavoritesScreen(component: FavoritesComponent) {
    MVIScreen(
        viewModel = component.viewModel,
        handleAction = component::handleAction
    ) { state, intentConsumer ->
        FavoritesView(state, intentConsumer)
    }
}
