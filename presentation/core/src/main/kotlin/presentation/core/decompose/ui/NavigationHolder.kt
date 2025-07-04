package presentation.core.decompose.ui

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.experimental.stack.ChildStack
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import presentation.core.decompose.BaseChild
import presentation.core.navigation.animation.appStackAnimation

@OptIn(ExperimentalDecomposeApi::class)
@Composable
fun <C : Any, T : BaseChild> NavigationHolder(
    stack: Value<ChildStack<C, T>>,
    content: @Composable (T) -> Unit
) {
    ChildStack(
        stack = stack,
        animation = appStackAnimation()
    ) {
        content(it.instance)
    }
}
