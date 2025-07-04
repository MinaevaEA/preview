package presentation.uikit.scrollbehavior

import android.util.Log
import androidx.compose.animation.core.AnimationState
import androidx.compose.animation.core.DecayAnimationSpec
import androidx.compose.animation.core.animateDecay
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.unit.Velocity
import kotlin.math.abs
import kotlin.math.roundToInt

@Stable
class ExitUntilCollapsedNestedScrollConnection(
    val state: State,
    val flingAnimationSpec: DecayAnimationSpec<Float>,
) : NestedScrollConnection {

    var offset: Int = state.offset
        get() = state.offset
        private set(value) {
            state.offset = value
            field = value
        }

    class State(
        val maxHeight: Int,
        val minHeight: Int = 0,
        initialOffset: Int = 0
    ) {
        var offset: Int by mutableIntStateOf(initialOffset)

        @Composable
        fun rememberProgress() = remember(offset) {
            derivedStateOf {
                val percent = (offset.toFloat() / (maxHeight - minHeight))
                val result = percent.times(-1).coerceIn(0f, 1f)
                Log.e("OPACITY", result.toString())
                result
            }
        }

        companion object {
            val Saver = listSaver<State, Int>(
                save = { listOf(it.maxHeight, it.minHeight, it.offset) },
                restore = { State(it[0], it[1], it[2]) }
            )
        }
    }

    override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
        val delta = available.y.roundToInt()

        if (delta >= 0f) return Offset.Zero

        val prevOffset = offset
        val newOffset = offset + delta
        val heightDelta = -(state.maxHeight - state.minHeight)

        offset = if (heightDelta > 0) state.minHeight else newOffset.coerceIn(heightDelta, 0)
        val consumed = offset - prevOffset
        return Offset(0F, consumed.toFloat())
    }

    override fun onPostScroll(
        consumed: Offset,
        available: Offset,
        source: NestedScrollSource
    ): Offset {
        val delta = available.y.roundToInt()

        val prevOffset = offset
        val newOffset = offset + delta

        val heightDelta = -(state.maxHeight - state.minHeight)

        offset = if (heightDelta > 0) state.minHeight else newOffset.coerceIn(heightDelta, 0)

        val consumedValue = offset - prevOffset
        return Offset(0F, consumedValue.toFloat())
    }

    override suspend fun onPostFling(consumed: Velocity, available: Velocity): Velocity {
        var result = super.onPostFling(consumed, available)
        val posOffset = abs(offset)

        if (posOffset > 0.01f && posOffset > state.minHeight && posOffset < state.maxHeight) {
            result += fling(available.y, flingAnimationSpec)
        }

        return result
    }

    private suspend fun fling(
        initialVelocity: Float,
        flingAnimationSpec: DecayAnimationSpec<Float>
    ): Velocity {
        var remainingVelocity = initialVelocity

        if (abs(initialVelocity) > 1f) {
            var lastValue = 0f
            AnimationState(
                initialValue = 0f,
                initialVelocity = initialVelocity
            )
                .animateDecay(flingAnimationSpec) {
                    val delta = value - lastValue
                    val prevOffset = offset
                    val newOffset = (prevOffset + delta).roundToInt()
                    val heightDelta = -(state.maxHeight - state.minHeight)
                    offset = newOffset.coerceIn(heightDelta, 0)
                    val consumed = abs(prevOffset - offset)
                    lastValue = value
                    remainingVelocity = this.velocity

                    if (abs(delta - consumed) > 0.5f) {
                        cancelAnimation()
                    }
                }
        }

        return Velocity(0f, remainingVelocity)
    }

}
