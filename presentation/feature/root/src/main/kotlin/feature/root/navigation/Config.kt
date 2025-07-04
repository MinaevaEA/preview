package feature.root.navigation

import kotlinx.serialization.Serializable
import presentation.core.decompose.BaseConfig

@Serializable
internal sealed interface Config : BaseConfig {

    @Serializable
    data object Main : Config

}
