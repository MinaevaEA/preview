package presentation.core.ui

import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.badoo.reaktive.disposable.scope.DisposableScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onSubscription
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import presentation.core.ui.util.ViewMessage
import util.debugging.Logger

abstract class BaseViewModel<S : BaseState, I : BaseIntent, A : BaseAction>(
    initialState: S
) : InstanceKeeper.Instance, DisposableScope by DisposableScope() {

    protected val coroutineScope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    private val _viewState = MutableStateFlow(initialState)
    private val _action = Channel<A>(
        capacity = Channel.BUFFERED,
        onUndeliveredElement = {
            Logger.error(IllegalStateException("Action $it was not delivered to consumer"))
        }
    )
    private val _viewMessage = MutableSharedFlow<ViewMessage>(replay = 0)

    protected var viewState: S
        get() = _viewState.value
        set(value) {
            _viewState.value = reduceState(value)
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    protected var action: A? = null
        set(value) {
            coroutineScope.launch(Dispatchers.Main) {
                if (value != null) {
                    onNewAction(value)
                    _action.send(value)
                }
            }
        }

    fun resetActions() {
        action = null
    }

    val viewStates: StateFlow<S>
        get() = _viewState.asStateFlow()

    val viewActions: Flow<A>
        get() = _action.receiveAsFlow()

    val messages: SharedFlow<ViewMessage>
        get() = _viewMessage.asSharedFlow()

    abstract fun obtainIntent(intent: I)

    open fun onNewAction(action: A) {}

    open fun reduceState(state: S): S {
        return state
    }

    protected fun notifyError(ex: Throwable) {
        coroutineScope.launch(Dispatchers.Main) {
            _viewMessage.emit(ViewMessage.Error(ex))
        }
    }

    protected fun showToast(message: String) {
        coroutineScope.launch(Dispatchers.Main) {
            _viewMessage.emit(ViewMessage.Success(message))
        }
    }

    override fun onDestroy() {
        coroutineScope.cancel()
        this.dispose()
    }

}
