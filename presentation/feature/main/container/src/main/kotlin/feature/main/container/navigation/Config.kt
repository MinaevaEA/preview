package feature.main.container.navigation

import kotlinx.serialization.Serializable
import presentation.core.decompose.BaseConfig
import presentation.model.enums.NavTab
import presentation.model.human.CategoryHuman
import presentation.model.human.LectureHuman

@Serializable
internal sealed interface Config : BaseConfig {

    @Serializable
    data class NavBar(val initialTab: NavTab) : Config

    @Serializable
    data class LectureDetail(val lecture: LectureHuman) : Config

    @Serializable
    data class CategoryDetail(val category: CategoryHuman) : Config

    object SelectCategory: Config

}
