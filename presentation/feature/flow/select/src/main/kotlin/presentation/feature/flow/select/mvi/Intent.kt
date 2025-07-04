package presentation.feature.flow.select.mvi

import presentation.core.ui.BaseIntent

internal interface Intent : BaseIntent {
    object onBack : Intent
}
