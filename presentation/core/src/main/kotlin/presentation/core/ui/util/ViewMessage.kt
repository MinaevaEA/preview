package presentation.core.ui.util

import androidx.compose.runtime.Immutable

@Immutable
sealed interface ViewMessage {

    data class Error(val ex: Throwable) : ViewMessage

    data class Success(val message: String) : ViewMessage

}
