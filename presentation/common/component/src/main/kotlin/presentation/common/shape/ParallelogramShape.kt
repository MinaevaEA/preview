package presentation.common.shape

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection

class ParallelogramShape(
    private val offset: Dp,
    private val angleDirection: Direction = Direction.START
) : Shape {

    enum class Direction {
        START, END
    }

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val offsetPx = with(density) { offset.toPx() }

        val path = Path().apply {
            when(angleDirection) {
                Direction.START -> {
                    moveTo(0f, size.height)
                    lineTo(offsetPx, 0f)
                    lineTo(size.width, 0f)
                    lineTo(size.width - offsetPx, size.height)
                    close()
                }
                Direction.END -> {
                    moveTo(0f, 0f)
                    lineTo(offsetPx, size.height)
                    lineTo(size.width, size.height)
                    lineTo(size.width - offsetPx, 0f)
                    close()
                }
            }
        }

        return Outline.Generic(path)
    }

}
