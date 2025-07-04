package feature.lectures.list.ui.mvi

import presentation.core.ui.BaseAction
import presentation.model.human.CategoryHuman
import presentation.model.human.LectureHuman

internal sealed interface Action : BaseAction {

    class SelectCategory() : Action

    class OpenMastermind() : Action

    data class OpenLecture(val lectureHuman: LectureHuman) : Action

    data class OpenCategory(val categoryHuman: CategoryHuman) : Action

}
