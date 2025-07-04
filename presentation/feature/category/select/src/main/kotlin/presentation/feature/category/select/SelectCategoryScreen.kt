package presentation.feature.category.select

import androidx.compose.runtime.Composable
import presentation.core.screen.MVIScreen
import presentation.feature.category.select.ui.SelectCategoryView

@Composable
public fun SelectCategoryScreen(component: SelectCategoryComponent) {
    MVIScreen(
        viewModel = component.viewModel,
        handleAction = component::handleAction
    ) { state, intentConsumer ->
        SelectCategoryView(state, intentConsumer)
    }
}
