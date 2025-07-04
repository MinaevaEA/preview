package presentation.core.navigation.animation

import androidx.compose.animation.core.tween
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.experimental.stack.animation.StackAnimation
import com.arkivanov.decompose.extensions.compose.experimental.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.stack.animation.Direction
import com.arkivanov.decompose.extensions.compose.experimental.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.experimental.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.experimental.stack.animation.slide
import presentation.core.decompose.BaseChild
import presentation.core.navigation.animation.animator.blackOutAnimator
import presentation.core.navigation.animation.animator.slideFromBottomAnimator
import presentation.core.navigation.animation.animator.slideFromRightAnimator
import presentation.core.navigation.animation.animator.slideReversed

private const val SLIDE_DURATION = 500

@OptIn(ExperimentalDecomposeApi::class)
fun <C : Any, T : BaseChild> appStackAnimation(): StackAnimation<C, T> =
    stackAnimation { child, otherChild, direction, _ ->
        val childTransition = child.instance.transition
        val anotherChildTransition = otherChild.instance.transition

        val actualTransition = when (direction) {
            Direction.ENTER_FRONT -> childTransition
            Direction.ENTER_BACK -> anotherChildTransition
            Direction.EXIT_FRONT -> childTransition
            Direction.EXIT_BACK -> anotherChildTransition
        }

        when (actualTransition) {
            ScreenTransition.SLIDE_FROM_RIGHT ->
                slideFromRightAnimator(SLIDE_DURATION) + blackOutAnimator(SLIDE_DURATION)
            ScreenTransition.SLIDE_FROM_BOTTOM ->
                fade(tween(SLIDE_DURATION)) + slideFromBottomAnimator(SLIDE_DURATION) + blackOutAnimator(SLIDE_DURATION)
            ScreenTransition.SLIDE_HORIZONTAL -> slide(tween(SLIDE_DURATION))
            ScreenTransition.SLIDE_HORIZONTAL_REVERSED -> slideReversed(tween(SLIDE_DURATION))
            ScreenTransition.FADE -> fade()
        }
    }


