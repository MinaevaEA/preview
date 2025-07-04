package feature.main.navbar.ui.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import feature.main.navbar.model.TopLevelDestination
import kotlinx.collections.immutable.ImmutableList
import presentation.model.enums.NavTab
import presentation.uikit.theme.AppColors
import presentation.uikit.theme.AppTypography

@Composable
internal fun AppBottomNavigation(
    destinations: ImmutableList<TopLevelDestination>,
    selectedTab: NavTab,
    onTabClick: (NavTab) -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = AppColors.neutral95,
            ) {
                destinations.forEach { destination ->
                    val isSelected = destination.matchTab(selectedTab)
                    val iconRes = remember(isSelected) {
                        if (isSelected) destination.selectedIconRes else destination.unselectedIconRes
                    }
                    val title = stringResource(destination.titleRes)

                    NavigationBarItem(
                        selected = isSelected,
                        colors = NavigationBarItemColors(
                            selectedIconColor = AppColors.accent30,
                            selectedTextColor = AppColors.accent30,
                            unselectedIconColor = AppColors.neutral50,
                            unselectedTextColor = AppColors.neutral50,
                            disabledIconColor = AppColors.neutral50,
                            disabledTextColor = AppColors.neutral50,
                            selectedIndicatorColor = AppColors.accent0
                        ),
                        icon = {
                            Icon(
                                painter = painterResource(iconRes),
                                contentDescription = title,
                            )
                        },
                        label = {
                            Text(
                                text = title,
                                style = AppTypography.captionSmall.medium,
                            )
                        },
                        alwaysShowLabel = true,
                        onClick = {
                            if (!destination.matchTab(selectedTab)) onTabClick(destination.getTab())
                        }
                    )
                }
            }
        }
    ) { padding ->
        content(padding)
    }
}
