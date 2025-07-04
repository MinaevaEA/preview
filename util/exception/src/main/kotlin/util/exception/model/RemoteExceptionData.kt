package util.exception.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteExceptionData(
    val type: String?,
    @SerialName("message")
    val subtype: String?,
    @SerialName("message_rus")
    val message: String?,
    val details: String?
)
