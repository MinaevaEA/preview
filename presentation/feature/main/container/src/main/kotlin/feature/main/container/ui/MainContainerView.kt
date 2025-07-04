package feature.main.container.ui

import androidx.compose.runtime.Composable
import feature.main.container.ui.mvi.Intent
import feature.main.container.ui.mvi.State

@Composable
internal fun MainContainerView(
    state: State,
    intentConsumer: (Intent) -> Unit,
    content: @Composable () -> Unit
) {
    content()
}
