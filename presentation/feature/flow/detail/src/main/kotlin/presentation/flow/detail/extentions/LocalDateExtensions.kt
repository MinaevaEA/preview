package presentation.flow.detail.extentions

import java.time.LocalDate
import java.time.format.DateTimeFormatter

internal fun LocalDate.getTitle(): String {
    val formatter = DateTimeFormatter.ofPattern("dd MMMM")
    return this.format(formatter)
}
