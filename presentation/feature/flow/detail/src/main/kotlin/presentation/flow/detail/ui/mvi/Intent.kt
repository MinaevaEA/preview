package presentation.flow.detail.ui.mvi

import presentation.core.ui.BaseIntent
import java.time.LocalDate

internal interface Intent : BaseIntent {

    object onBack : Intent

    data class OnDateSelect(val date: LocalDate) : Intent
}
