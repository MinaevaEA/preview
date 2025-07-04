package presentation.core.decompose

import com.arkivanov.decompose.ComponentContext
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerializationStrategy
import presentation.core.ui.BaseState
import presentation.core.ui.BaseViewModel

/**
 *
 */
abstract class BaseComponent(
    componentContext: ComponentContext
) : ComponentContext by componentContext {

    fun <S : BaseState> initStateSaver(
        strategy: SerializationStrategy<S>,
        supplier: () -> S?
    ) {
        stateKeeper.register(
            key = "${this::class.qualifiedName!!}_VIEW_STATE",
            strategy = strategy,
            supplier = supplier
        )
    }

    fun <S : BaseState> restoreState(
        strategy: DeserializationStrategy<S>
    ): S? = stateKeeper.consume(
        key = "${this::class.qualifiedName!!}_VIEW_STATE",
        strategy = strategy
    )

    fun <S: BaseState> BaseViewModel<S, *, *>.currentState() = this.viewStates.value

}
