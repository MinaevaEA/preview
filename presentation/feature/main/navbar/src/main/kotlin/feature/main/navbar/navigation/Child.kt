package feature.main.navbar.navigation

import feature.lectures.list.LecturesListComponent
import presentation.core.decompose.BaseChild
import presentation.core.navigation.animation.ScreenTransition
import presentation.feature.favorites.FavoritesComponent

internal sealed class Child : BaseChild() {

    override val transition: ScreenTransition = ScreenTransition.FADE

    data class Lectures(val component: LecturesListComponent) : Child()

    data class Favorites(val component: FavoritesComponent) : Child()

    data class Partners(val component: String) : Child()

    data class About(val component: String) : Child()

}
