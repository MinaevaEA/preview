package presentation.feature.flow.select

import androidx.compose.runtime.Composable
import presentation.core.screen.MVIScreen
import presentation.feature.flow.select.ui.SelectCategoryView

@Composable
public fun SelectCategoryScreen(component: SelectCategoryComponent) {
    MVIScreen(
        viewModel = component.viewModel,
        handleAction = component::handleAction
    ) { state, intentConsumer ->
        SelectCategoryView(state, intentConsumer)
    }
}
