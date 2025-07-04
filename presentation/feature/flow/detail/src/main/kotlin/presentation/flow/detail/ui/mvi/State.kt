package presentation.flow.detail.ui.mvi

import kotlinx.collections.immutable.persistentListOf
import kotlinx.serialization.Serializable
import presentation.core.ui.BaseState
import presentation.model.human.CategoryHuman
import presentation.model.human.EventHuman
import presentation.model.human.LectureHuman
import presentation.model.serializer.SerializableLocalDate
import java.time.LocalDate

@Serializable
internal data class State(
    val category: CategoryHuman,
    val event: EventHuman,
    val lectures: List<LectureHuman>,
    val selectedDate: SerializableLocalDate = event.dates.first(),
) : BaseState {

    fun changeSelectedDate(newDate: LocalDate) = this.copy(selectedDate = newDate)

    companion object{
        fun getPreview() = State(
            category = CategoryHuman.getPreview(),
            event = EventHuman.getPreview(),
            lectures = persistentListOf(LectureHuman.getPreview()),
        )
    }
}
