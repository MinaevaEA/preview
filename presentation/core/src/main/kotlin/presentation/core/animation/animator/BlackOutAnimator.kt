package presentation.core.navigation.animation.animator

import androidx.compose.animation.core.tween
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.experimental.stack.animation.StackAnimator
import com.arkivanov.decompose.extensions.compose.experimental.stack.animation.stackAnimator
import com.arkivanov.decompose.extensions.compose.stack.animation.isBack

@OptIn(ExperimentalDecomposeApi::class)
fun blackOutAnimator(
    duration: Int = 500,
    color: Color = Color(0xFF000000),
    opacity: Float = 0.5f
): StackAnimator = stackAnimator(
    animationSpec = tween(duration),
    frame = { factor, direction ->
        val blackoutFactor = if (direction.isBack) -opacity * factor else 0f

        Modifier.drawWithContent {
            drawContent()
            drawRect(
                color = color,
                size = this.size,
                alpha = blackoutFactor
            )
        }
    }
)
