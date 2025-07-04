package feature.lectures.detail.ui.mvi

import kotlinx.serialization.Serializable
import presentation.core.ui.BaseState
import presentation.model.human.CategoryHuman
import presentation.model.human.LectureHuman

@Serializable
internal data class State(
    val lectureHuman: LectureHuman,
    val categoryHuman: CategoryHuman,
    val isFavorite: Boolean
) : BaseState {

    companion object {

        fun getPreview() = State(
            lectureHuman = LectureHuman.getPreview(),
            categoryHuman = CategoryHuman.getPreview(),
            true
        )
    }
}
