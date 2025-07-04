package presentation.core.navigation.animation.animator

import androidx.compose.animation.core.tween
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.stack.animation.Direction
import com.arkivanov.decompose.extensions.compose.experimental.stack.animation.StackAnimator
import com.arkivanov.decompose.extensions.compose.experimental.stack.animation.stackAnimator
import com.arkivanov.decompose.extensions.compose.stack.animation.isFront

@OptIn(ExperimentalDecomposeApi::class)
fun slideFromRightAnimator(
    duration: Int = 500,
    shift: Float = 0.25f
): StackAnimator = stackAnimator(
    animationSpec = tween(durationMillis = duration),
    frame = { factor, direction ->
        val slideFactor = if (direction.isFront) factor else factor * shift

        Modifier
            .layout { measurable, constraints ->
                val placeable = measurable.measure(constraints)

                layout(placeable.width, placeable.height) {
                    placeable.placeRelative(
                        x = (placeable.width.toFloat() * slideFactor).toInt(),
                        y = 0
                    )
                }
            }
            .clip(RoundedCornerShape(24.dp))
    }
)
