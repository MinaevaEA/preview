package presentation.feature.category.detail.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import presentation.common.component.LectureCard
import presentation.feature.category.detail.ui.component.BigImageCategory
import presentation.feature.category.detail.ui.mvi.Intent
import presentation.feature.category.detail.ui.mvi.State
import presentation.model.human.CategoryHuman
import presentation.model.human.EventHuman
import presentation.model.human.LectureHuman
import presentation.uikit.component.segmentcontrol.SegmentControlPrimary
import presentation.uikit.theme.AppColors
import presentation.uikit.theme.AppTheme

@Composable
internal fun DetailCategoryView(
    state: State,
    intentConsumer: (Intent) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.neutral100)
    ) {
        BigImageCategory(
            onBackClick = { intentConsumer(Intent.onBack) },
            image = state.category.photo,
            categoryHuman = state.category)
        SegmentControlPrimary(
            modifier = Modifier.padding(vertical = 8.dp),
            tabs = state.event.dates,
            selected = state.selectedDate,
            getTabText = { "Test" },
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
                        items(state.lectures) { lecture ->
                            LectureCard(
                                lecture = lecture,
                                onClick = { },
                                onFavoriteClick = {}
                            )
                        }

                        item {
                            Spacer(Modifier.height(8.dp))
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun DetailCategoryViewPreview() {
    AppTheme {
        Column(
            Modifier
                .height(1900.dp)
                .width(900.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            DetailCategoryView(
                State(
                    event = EventHuman.getPreview(),
                    category = CategoryHuman.getPreview(),
                    lectures = listOf(LectureHuman.getPreview())
                ), {})
        }
    }
}
