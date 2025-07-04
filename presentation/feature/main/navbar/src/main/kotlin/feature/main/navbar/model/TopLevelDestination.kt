package feature.main.navbar.model

import androidx.annotation.StringRes
import presentation.model.enums.NavTab
import presentation.resources.R

internal enum class TopLevelDestination(
    @StringRes val titleRes: Int,
    @StringRes val unselectedIconRes: Int,
    @StringRes val selectedIconRes: Int
) {

    LECTURES(
        titleRes = R.string.tab_lectures,
        unselectedIconRes = R.drawable.ic_tab_lectures,
        selectedIconRes = R.drawable.ic_tab_lectures_filled
    ),

    FAVORITES(
        titleRes = R.string.tab_favorites,
        unselectedIconRes = R.drawable.ic_tab_favorites,
        selectedIconRes = R.drawable.ic_tab_favorites_filled
    ),

    PARTNERS(
        titleRes = R.string.tab_partners,
        unselectedIconRes = R.drawable.ic_tab_partners,
        selectedIconRes = R.drawable.ic_tab_partners_filled
    ),

    ABOUT(
        titleRes = R.string.tab_about,
        unselectedIconRes = R.drawable.ic_tab_about,
        selectedIconRes = R.drawable.ic_tab_about_filled
    );

    fun getTab() = when(this) {
        LECTURES -> NavTab.LECTURES
        FAVORITES -> NavTab.FAVORITES
        PARTNERS -> NavTab.PARTNERS
        ABOUT -> NavTab.ABOUT
    }

    fun matchTab(tab: NavTab)= when(this) {
        LECTURES -> tab == NavTab.LECTURES
        FAVORITES -> tab == NavTab.FAVORITES
        PARTNERS -> tab == NavTab.PARTNERS
        ABOUT -> tab == NavTab.ABOUT
    }

}
