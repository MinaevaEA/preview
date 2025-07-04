package presentation.feature.category.select.mvi

import kotlinx.collections.immutable.persistentListOf
import kotlinx.serialization.Serializable
import presentation.core.ui.BaseState
import presentation.feature.category.select.mvi.enum.TypeSelect
import presentation.model.human.CategoryHuman
import presentation.model.serializer.SerializableImmutableList

@Serializable
internal data class State(val category: SerializableImmutableList<CategoryHuman>, val isSelected: TypeSelect) : BaseState {
    companion object {

        fun getPreview() = State(
           category = persistentListOf(CategoryHuman.getPreview(), CategoryHuman.getPreview()),
            isSelected = TypeSelect.SELECTED
        )
    }
}
