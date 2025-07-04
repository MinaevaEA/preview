package feature.lectures.list.ui.mvi

import kotlinx.collections.immutable.persistentListOf
import kotlinx.serialization.Serializable
import presentation.core.ui.BaseState
import presentation.model.human.CategoryHuman
import presentation.model.human.EventHuman
import presentation.model.human.LectureHuman
import presentation.model.serializer.SerializableImmutableList
import presentation.model.serializer.SerializableLocalDate
import java.time.LocalDate

@Serializable
internal data class State(
    val event: EventHuman,
    val lectures: SerializableImmutableList<LectureHuman>,
    val categories: SerializableImmutableList<CategoryHuman>,
    val selectedDate: SerializableLocalDate = event.dates.first(),
    val isRefreshing: Boolean = false
) : BaseState {

    fun changeSelectedDate(newDate: LocalDate) = this.copy(selectedDate = newDate)

    fun toggleRefreshing(isRefreshing: Boolean) = this.copy(isRefreshing = isRefreshing)

    companion object {

        fun getPreview() = State(
            event = EventHuman.getPreview(),
            lectures = persistentListOf(
                LectureHuman.getPreview(),
                LectureHuman.getPreview(),
                LectureHuman.getPreview(),
                LectureHuman.getPreview(),
                LectureHuman.getPreview(),
                LectureHuman.getPreview(),
            ),
            categories = persistentListOf(
                CategoryHuman.getPreview()
            )
        )
    }
}
