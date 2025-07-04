package presentation.model.human

import kotlinx.serialization.Serializable

@Serializable
data class SpeakerHuman(
    val name: String,
    val photo: String,
    val appointment: String,
    val logoCompany: String
) {

    companion object {
        fun getPreview() = SpeakerHuman(
            name = "Александр Богданов",
            photo = "https://static.tildacdn.com/tild6131-6165-4138-b962-613838623661/3-3.png",
            appointment = "AGIMA, основатель",
            logoCompany = "https://static.tildacdn.com/tild6131-6165-4138-b962-613838623661/3-3.png"
        )
    }

}

