package presentation.feature.favorites.ui.mvi

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import kotlinx.collections.immutable.persistentListOf
import kotlinx.serialization.Serializable
import presentation.core.ui.BaseState
import presentation.model.human.CategoryHuman
import presentation.model.human.EventHuman
import presentation.model.human.LectureHuman
import presentation.model.serializer.SerializableImmutableList
import presentation.model.serializer.SerializableLocalDate
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Serializable
internal data class State(
    val event: EventHuman,
    val lectures: SerializableImmutableList<LectureHuman>,
    val categories: SerializableImmutableList<CategoryHuman>,
    val selectedDate: SerializableLocalDate = event.dates.first(),
    val date: SerializableLocalDate
) : BaseState{

    @Composable
    fun rememberDate() = remember(date) {
        val formatter = DateTimeFormatter.ofPattern("dd MMMM")
        date.format(formatter)
    }

    fun changeSelectedDate(newDate: LocalDate) = this.copy(selectedDate = newDate)

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
            ), date = LocalDate.of(2025, 9, 24)
        )
    }
}
