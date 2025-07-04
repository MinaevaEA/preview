package feature.lectures.list.ui.mvi

import presentation.core.ui.BaseIntent
import presentation.model.human.CategoryHuman
import presentation.model.human.LectureHuman
import java.time.LocalDate

internal sealed interface Intent : BaseIntent {

    data object OnSelectCategoryClick : Intent

    data object OnMastermindClick : Intent

    data class OnDateSelect(val date: LocalDate) : Intent

    data class OnLectureClick(val lecture: LectureHuman) : Intent

    data class OnCategoryClick(val category: CategoryHuman) : Intent

    data object OnRefresh : Intent

}
