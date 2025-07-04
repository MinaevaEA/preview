package presentation.core.screen

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import presentation.core.ui.BaseAction
import presentation.core.ui.BaseIntent
import presentation.core.ui.BaseState
import presentation.core.ui.BaseViewModel
import presentation.core.ui.util.ViewMessage

@Composable
fun <S : BaseState, I : BaseIntent, A : BaseAction> MVIScreen(
    viewModel: BaseViewModel<S, I, A>,
    handleAction: (action: A) -> Unit,
    handleMessage:(suspend (ViewMessage) -> Unit)? = null,
    view: @Composable (state: S, intentConsumer: (I) -> Unit) -> Unit
) {
    val context = LocalContext.current

    val state by viewModel.viewStates.collectAsStateWithLifecycle()
    val message by viewModel.messages.collectAsStateWithLifecycle(null)
    val action by viewModel.viewActions.collectAsState(null)

    LaunchedEffect(action) {
        action?.let {
            Log.e(viewModel::class.simpleName, "HANDLE ACTION: $action")
            handleAction(it)
        }
    }

    LaunchedEffect(message) {
        message?.let {
            handleMessage?.invoke(it) ?: defaultMessageHandler(context, it)
        }
    }

    view(state, viewModel::obtainIntent)
}

private fun defaultMessageHandler(
    context: Context,
    message: ViewMessage,
) {
    val text = when(message) {
        is ViewMessage.Error -> message.ex.message
        is ViewMessage.Success -> message.message
    }

    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}
