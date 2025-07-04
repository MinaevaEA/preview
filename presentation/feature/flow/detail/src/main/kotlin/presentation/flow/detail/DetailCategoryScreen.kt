package presentation.flow.detail

import androidx.compose.runtime.Composable
import presentation.core.screen.MVIScreen
import presentation.flow.detail.ui.DetailCategoryComponent
import presentation.flow.detail.ui.DetailCategoryView

@Composable
public fun DetailCategoryScreen(component: DetailCategoryComponent) {
    MVIScreen(
        viewModel = component.viewModel,
        handleAction = component::handleAction
    ) { state, intentConsumer ->
        DetailCategoryView(state, intentConsumer)
    }
}
