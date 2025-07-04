package presentation.model.human

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import kotlinx.collections.immutable.persistentListOf
import kotlinx.serialization.Serializable
import presentation.model.serializer.SerializableImmutableList
import presentation.model.serializer.SerializableLocalDate
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Serializable
data class EventHuman(
    val place: String,
    val eventTime: String,
    val dates: SerializableImmutableList<SerializableLocalDate>
) : Human {

    @Composable
    fun rememberDatesRange(): String = remember(dates) {
        val monthFormatter = DateTimeFormatter.ofPattern("MMMM")
        val month = dates.lastOrNull()?.let { it.format(monthFormatter) }.orEmpty()

        if (dates.size > 1) {
            "${dates.first().dayOfMonth}-${dates.last().dayOfMonth} $month"
        } else {
            dates.firstOrNull()?.let { it.dayOfMonth }?.let { "$it $month" }.orEmpty()
        }
    }

    companion object {
        fun getPreview() = EventHuman(
            place = "Москва, Сколково",
            eventTime = "23-24 Сентября 2025",
            dates = persistentListOf(LocalDate.of(2025, 9, 23), LocalDate.of(2025, 9, 24))
        )
    }

}
