package feature.root

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import feature.main.container.MainContainerScreen
import feature.root.navigation.Child
import feature.root.ui.RootView
import presentation.core.decompose.ui.NavigationHolder
import presentation.core.screen.MVIScreen

@Composable
public fun RootScreen(component: RootComponent) {
    MVIScreen(
        viewModel = component.viewModel,
        handleAction = component::handleAction
    ) { state, intentConsumer ->
        RootView(state, intentConsumer) {
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
        is Child.Main -> MainContainerScreen(child.component)
    }
}
