package feature.main.navbar.navigation

import feature.main.navbar.model.TopLevelDestination
import kotlinx.serialization.Serializable
import presentation.core.decompose.BaseConfig
import presentation.model.enums.NavTab

@Serializable
internal sealed interface Config : BaseConfig {

    val tab: NavTab
    val destination: TopLevelDestination

    @Serializable
    data object Lectures : Config {
        override val tab: NavTab = NavTab.LECTURES
        override val destination: TopLevelDestination = TopLevelDestination.LECTURES
    }

    @Serializable
    data object Favorites : Config {
        override val tab: NavTab = NavTab.FAVORITES
        override val destination: TopLevelDestination = TopLevelDestination.FAVORITES
    }

    @Serializable
    data object Partners : Config {
        override val tab: NavTab = NavTab.PARTNERS
        override val destination: TopLevelDestination = TopLevelDestination.PARTNERS
    }

    @Serializable
    data object About : Config {
        override val tab: NavTab = NavTab.ABOUT
        override val destination: TopLevelDestination = TopLevelDestination.ABOUT
    }

    companion object {
        fun fromTab(navTab: NavTab): Config = when (navTab) {
            NavTab.LECTURES -> Lectures
            NavTab.FAVORITES -> Favorites
            NavTab.PARTNERS -> Partners
            NavTab.ABOUT -> About
        }
    }
}
