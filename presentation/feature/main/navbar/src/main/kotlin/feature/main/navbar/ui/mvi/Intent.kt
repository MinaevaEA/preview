package feature.main.navbar.ui.mvi

import presentation.core.ui.BaseIntent
import presentation.model.enums.NavTab

internal sealed interface Intent : BaseIntent {

    data class OnTabClick(val tab: NavTab) : Intent

    data class OnTabChanged(val newTab: NavTab) : Intent

}
