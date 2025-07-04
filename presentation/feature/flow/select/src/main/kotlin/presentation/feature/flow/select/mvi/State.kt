package presentation.feature.flow.select.mvi

import kotlinx.collections.immutable.persistentListOf
import kotlinx.serialization.Serializable
import presentation.core.ui.BaseState
import presentation.feature.flow.select.mvi.enum.TypeSelect
import presentation.model.human.CategoryHuman

@Serializable
internal data class State(val flows: List<CategoryHuman>, val isSelected: TypeSelect) : BaseState {
    companion object {

        fun getPreview() = State(
           flows = persistentListOf(CategoryHuman.getPreview()),
            isSelected = TypeSelect.SELECTED
        )
    }
}
