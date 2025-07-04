package feature.lectures.detail.ui

import androidx.compose.runtime.Composable
import presentation.core.screen.MVIScreen

@Composable
public fun DetailLecturesScreen(component: DetailLectureComponent) {
    MVIScreen(
        viewModel = component.viewModel,
        handleAction = component::handleAction
    ) { state, intentConsumer ->
        DetailLectureView(state, intentConsumer)
    }
}
