package presentation.feature.favorites.ui.mvi

import presentation.core.ui.BaseAction
import presentation.model.human.LectureHuman

internal interface Action : BaseAction {

    data class OpenLecture(val lectureHuman: LectureHuman) : Action
}
