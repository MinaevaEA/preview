package feature.lectures.list.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults
import androidx.compose.material3.pulltorefresh.PullToRefreshState
import androidx.compose.material3.pulltorefresh.pullToRefresh
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import feature.lectures.list.extensions.getTitle
import feature.lectures.list.ui.component.CategoryItem
import feature.lectures.list.ui.component.MastermindBanner
import feature.lectures.list.ui.component.TopBar
import feature.lectures.list.ui.mvi.Intent
import feature.lectures.list.ui.mvi.State
import presentation.common.component.LectureCard
import presentation.resources.R
import presentation.uikit.component.segmentcontrol.SegmentControlPrimary
import presentation.uikit.scrollbehavior.ExitUntilCollapsedNestedScrollConnection
import presentation.uikit.theme.AppColors
import presentation.uikit.theme.AppTheme
import presentation.uikit.theme.AppTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun LecturesListView(
    state: State,
    intentConsumer: (Intent) -> Unit
) {
    val density = LocalDensity.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        TopBar(
            modifier = Modifier.padding(top = 16.dp),
            event = state.event,
            onSelectCategoryClick = { intentConsumer(Intent.OnSelectCategoryClick) }
        )

        val appBarMaxHeight = with(density) { 146.dp.roundToPx() }
        val nestedScrollState = rememberSaveable(
            saver = ExitUntilCollapsedNestedScrollConnection.State.Saver
        ) {
            ExitUntilCollapsedNestedScrollConnection.State(maxHeight = appBarMaxHeight)
        }
        val flingAnimationSpec = rememberSplineBasedDecay<Float>()
        val connection = remember(nestedScrollState, flingAnimationSpec) {
            ExitUntilCollapsedNestedScrollConnection(
                state = nestedScrollState,
                flingAnimationSpec = flingAnimationSpec
            )
        }
        val spaceHeight by remember(density) {
            derivedStateOf {
                with(density) { (appBarMaxHeight + connection.offset).toDp() }
            }
        }
        val pullRefreshState = rememberPullToRefreshState()

        Box(
            modifier = Modifier
                .fillMaxSize()
                .pullToRefresh(
                    isRefreshing = state.isRefreshing,
                    state = pullRefreshState,
                    onRefresh = { intentConsumer(Intent.OnRefresh) }
                )
                .nestedScroll(connection)
        ) {
            MastermindBanner(
                modifier = Modifier.padding(top = 8.dp),
                onButtonClick = { intentConsumer(Intent.OnMastermindClick) }
            )

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Spacer(Modifier.height(spaceHeight))

                LectionsList(state, pullRefreshState, intentConsumer)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LectionsList(
    state: State,
    pullRefreshState: PullToRefreshState,
    intentConsumer: (Intent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(AppColors.neutral95)
    ) {
        SegmentControlPrimary(
            modifier = Modifier.padding(vertical = 8.dp),
            tabs = state.event.dates,
            selected = state.selectedDate,
            getTabText = { it.getTitle() },
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
                        item {
                            Text(
                                modifier = Modifier.padding(top = 12.dp),
                                text = stringResource(R.string.title_lectures_list),
                                style = AppTypography.bodyXLarge.bold,
                                color =( AppColors.neutral0),
                                textAlign = TextAlign.Center
                            )
                        }
                        items(state.lectures) { lecture ->
                            LectureCard(
                                lecture = lecture,
                                onClick = { intentConsumer(Intent.OnLectureClick(lecture)) },
                                onFavoriteClick = {}
                            )
                        }

                        item {
                            Text(
                                modifier = Modifier.padding(top = 12.dp),
                                text = stringResource(R.string.title_category_list),
                                style = AppTypography.bodyXLarge.bold,
                                color =( AppColors.neutral0),
                                textAlign = TextAlign.Center
                            )
                        }

                        items(state.categories) { category ->
                            //пока неизвестна реализация как все таки будет, оставлю как есть, потом поправим
                            CategoryItem(category.category, onClick = { intentConsumer(Intent.OnCategoryClick(category))})
                        }
                    }
                }
            }

            PullToRefreshDefaults.Indicator(
                state = pullRefreshState,
                isRefreshing = state.isRefreshing,
                containerColor = AppColors.neutral80,
                color = AppColors.neutral0
            )
        }
    }
}

@Composable
@Preview
private fun LecturesListViewPreview() {
    AppTheme {
        Surface(color = AppColors.neutral95) {
            LecturesListView(
                state = State.getPreview(),
                intentConsumer = {}
            )
        }
    }
}
