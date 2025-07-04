package presentation.core.decompose

import androidx.compose.runtime.Immutable
import presentation.core.navigation.animation.ScreenTransition

@Immutable
abstract class BaseChild {

    open val transition: ScreenTransition = ScreenTransition.SLIDE_FROM_RIGHT

}
