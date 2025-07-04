package presentation.model.human

import kotlinx.serialization.Serializable

@Serializable
data class CategoryHuman(val category: String, val text: String, val color: Long, val photo: String) {
    companion object {
        fun getPreview() = CategoryHuman(
            text = "Управление агенством",
            color = 0xFFB8321C,
            category = "Дизайн",
            photo = "https://mendev.ru/img/company/sasha.webp"
        )
    }
}
