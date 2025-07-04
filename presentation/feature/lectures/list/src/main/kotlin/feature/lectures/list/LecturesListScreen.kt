package feature.lectures.list

import androidx.compose.runtime.Composable
import feature.lectures.list.ui.LecturesListView
import feature.lectures.list.ui.LecturesListViewNew
import presentation.core.screen.MVIScreen

@Composable
public fun LecturesListScreen(component: LecturesListComponent) {
    MVIScreen(
        viewModel = component.viewModel,
        handleAction = component::handleAction
    ) { state, intentConsumer ->
        LecturesListViewNew(state, intentConsumer)
    }
}
