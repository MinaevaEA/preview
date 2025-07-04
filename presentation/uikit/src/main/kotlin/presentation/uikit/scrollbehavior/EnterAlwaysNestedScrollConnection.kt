package presentation.uikit.scrollbehavior

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import kotlin.math.roundToInt

class EnterAlwaysNestedScrollConnection(
    val maxHeight: Int
) : NestedScrollConnection {

    var offset: Int by mutableIntStateOf(0)
        private set

    override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
        val delta = available.y.roundToInt()

        val prevOffset = offset
        val newOffset = offset + delta

        offset = newOffset.coerceIn(-maxHeight, 0)

        val consumed = offset - prevOffset

        System.out.println(consumed.toString())

        return Offset(0f, consumed.toFloat())
    }

}
