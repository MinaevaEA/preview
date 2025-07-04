package feature.root.navigation

import feature.main.container.MainContainerComponent
import presentation.core.decompose.BaseChild

internal sealed class Child : BaseChild() {

    data class Main(val component: MainContainerComponent) : Child()

}
