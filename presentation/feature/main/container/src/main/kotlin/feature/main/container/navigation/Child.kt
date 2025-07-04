package feature.main.container.navigation

import feature.main.navbar.NavBarComponent
import presentation.core.decompose.BaseChild
import presentation.feature.category.select.SelectCategoryComponent
import presentation.feature.category.detail.ui.DetailCategoryComponent
import feature.lectures.detail.ui.DetailLectureComponent

internal sealed class Child : BaseChild() {

    data class NavBar(val component: NavBarComponent) : Child()

    data class LectureDetail(val component: DetailLectureComponent) : Child()

    data class SelectCategory(val component: SelectCategoryComponent) : Child()

    data class OpenCategory(val component: DetailCategoryComponent) : Child()

}
