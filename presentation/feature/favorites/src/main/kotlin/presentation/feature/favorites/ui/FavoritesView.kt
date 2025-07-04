package presentation.feature.favorites.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import presentation.common.component.LectureCard
import presentation.feature.favorites.ui.component.Toolbar
import presentation.feature.favorites.ui.mvi.Intent
import presentation.feature.favorites.ui.mvi.State
import presentation.uikit.component.segmentcontrol.SegmentControlPrimary
import presentation.uikit.theme.AppColors
import presentation.uikit.theme.AppTheme

@Composable
internal fun FavoritesView(
    state: State,
    intentConsumer: (Intent) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(AppColors.neutral95)
            .statusBarsPadding()
    ) {
        Toolbar()
        SegmentControlPrimary(
            modifier = Modifier.padding(vertical = 8.dp),
            tabs = state.event.dates,
            selected = state.selectedDate,
            getTabText = { state.rememberDate() },
            onSelect = { intentConsumer(Intent.OnDateSelect(it)) },
        )

        Box(
            contentAlignment = Alignment.TopCenter
        ) {
            AnimatedContent(
                targetState = state.selectedDate
            ) { targetDate ->
                Box(
                    contentAlignment = Alignment.TopCenter
                ) {
                    LazyColumn(
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {

                        items(state.lectures.filter { it.isFavorite }) { lecture ->
                            LectureCard(
                                lecture = lecture,
                                onClick = { intentConsumer(Intent.OnLectureClick(lecture)) },
                                onFavoriteClick = {}
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview
private fun FavoritesViewPreview() {
    AppTheme {
        Surface(color = AppColors.neutral95) {
            FavoritesView(
                state = State.getPreview(),
                intentConsumer = {}
            )
        }
    }
}
