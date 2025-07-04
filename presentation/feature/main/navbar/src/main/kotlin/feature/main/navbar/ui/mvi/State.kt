package feature.main.navbar.ui.mvi

import kotlinx.serialization.Serializable
import presentation.core.ui.BaseState
import presentation.model.enums.NavTab

@Serializable
internal data class State(
    val currentTab: NavTab = NavTab.LECTURES,
) : BaseState {

    fun changeCurrentTab(newValue: NavTab) = this.copy(currentTab = newValue)

}
