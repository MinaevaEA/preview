package presentation.feature.favorites.ui.mvi

import presentation.core.ui.BaseIntent
import presentation.model.human.LectureHuman
import java.time.LocalDate

internal interface Intent : BaseIntent {

    data class OnDateSelect(val date: LocalDate) : Intent

    data class OnLectureClick(val lecture: LectureHuman) : Intent
}
