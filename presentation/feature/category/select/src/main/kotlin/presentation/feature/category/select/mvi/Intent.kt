package presentation.feature.category.select.mvi

import presentation.core.ui.BaseIntent

internal interface Intent : BaseIntent {
    object onBack : Intent
}
