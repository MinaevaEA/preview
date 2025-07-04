package presentation.model.human

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import kotlinx.collections.immutable.persistentListOf
import kotlinx.serialization.Serializable
import presentation.model.serializer.SerializableImmutableList
import presentation.model.serializer.SerializableLocalDate
import presentation.model.serializer.SerializableLocalTime
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Serializable
data class LectureHuman(
    val title: String,
    val description: String,
    val speakers: SerializableImmutableList<SpeakerHuman>,
    val category: CategoryHuman,
    val date: SerializableLocalDate,
    val from: SerializableLocalTime,
    val to: SerializableLocalTime,
    val isFavorite: Boolean,
    val photo: String
) : Human {

    @Composable
    fun rememberDate() = remember(date) {
        val formatter = DateTimeFormatter.ofPattern("dd MMMM")
        date.format(formatter)
    }

    @Composable
    fun rememberTime() = remember(from, to) {
        val formatter = DateTimeFormatter.ofPattern("HH:mm")
        "${from.format(formatter)}-${to.format(formatter)}"
    }

    fun toggleFavorite() = copy(isFavorite = !isFavorite)

    companion object {
        fun getPreview() = LectureHuman(
            title = "От ларька шаурмы к большому бизнесу. Чем на самом деле может стать интернет-агентство?",
            description = "Лекция об управлении дизайнерами мобильных приложений: ключевые принципы, работа в команде, постановка задач и контроль качества. Разбираем методы мотивации, agile-подходы и создание удобных интерфейсов. Практические кейсы и советы для тимлидов и продактов.",
            speakers = persistentListOf(SpeakerHuman.getPreview(), SpeakerHuman.getPreview()),
            category = CategoryHuman.getPreview(),
            date = LocalDate.of(2025, 9, 24),
            from = LocalTime.of(11, 0),
            to = LocalTime.of(12, 30),
            isFavorite = false,
            photo = "https://mendev.ru/img/company/sasha.webp"
        )
    }

}
