package feature.main.navbar.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import feature.main.navbar.model.TopLevelDestination
import feature.main.navbar.ui.component.AppBottomNavigation
import feature.main.navbar.ui.mvi.Intent
import feature.main.navbar.ui.mvi.State
import kotlinx.collections.immutable.toImmutableList
import presentation.uikit.theme.AppColors

@Composable
internal fun NavBarView(
    state: State,
    intentConsumer: (Intent) -> Unit,
    content: @Composable () -> Unit
) {
    AppBottomNavigation(
        destinations = remember { TopLevelDestination.entries.toImmutableList() },
        selectedTab = state.currentTab,
        onTabClick = { intentConsumer(Intent.OnTabClick(it)) }
    ) { padding ->
        Surface(
            modifier = Modifier.padding(bottom = padding.calculateBottomPadding()),
            color = AppColors.neutral95
        ) {
            content()
        }
    }
}
