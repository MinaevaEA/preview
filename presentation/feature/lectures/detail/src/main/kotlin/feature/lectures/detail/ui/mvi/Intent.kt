package feature.lectures.detail.ui.mvi

import presentation.core.ui.BaseIntent

internal interface Intent: BaseIntent{
    object onBack: Intent

    object onFavorite: Intent
    object onClickQuestion: Intent
}
