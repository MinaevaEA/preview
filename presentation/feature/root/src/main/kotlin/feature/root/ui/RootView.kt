package feature.root.ui

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import feature.root.ui.mvi.Intent
import feature.root.ui.mvi.State
import presentation.uikit.theme.AppColors

@Composable
internal fun RootView(
    state: State,
    intentConsumer: (Intent) -> Unit,
    content: @Composable () -> Unit,
) {
    content()
}
