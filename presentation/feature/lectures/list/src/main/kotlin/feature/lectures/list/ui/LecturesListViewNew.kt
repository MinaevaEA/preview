package feature.lectures.list.ui

import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import feature.lectures.list.ui.component.new.LOGO_HEIGHT
import feature.lectures.list.ui.component.new.MASTERMIND_HEIGHT
import feature.lectures.list.ui.component.new.MastermindBannerNew
import feature.lectures.list.ui.mvi.Intent
import feature.lectures.list.ui.mvi.State
import presentation.common.component.new.LectureCardNew
import presentation.uikit.scrollbehavior.ExitUntilCollapsedNestedScrollConnection
import presentation.uikit.theme.AppColors
import presentation.uikit.theme.AppTheme
import presentation.resources.R
import presentation.uikit.theme.typography.primaryFontFamily

@Composable
internal fun LecturesListViewNew(
    state: State,
    intentConsumer: (Intent) -> Unit
) {
    val insets = WindowInsets.statusBars
    val density = LocalDensity.current
    val statusBarHeight = remember(density, insets) {
        insets.getTop(density)
    }

    val mastermindMaxHeight = with(density) { (MASTERMIND_HEIGHT.dp - 24.dp).roundToPx() }
    val logoHeight = with(density) { (LOGO_HEIGHT + 24).dp.roundToPx() }
    val nestedScrollState = rememberSaveable(
        saver = ExitUntilCollapsedNestedScrollConnection.State.Saver
    ) {
        ExitUntilCollapsedNestedScrollConnection.State(
            maxHeight = mastermindMaxHeight,
            minHeight = statusBarHeight + logoHeight
        )
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
            with(density) { (mastermindMaxHeight + connection.offset).toDp() }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
            .nestedScroll(connection)
    ) {
        val connectionProgress by connection.state.rememberProgress()

        MastermindBannerNew(
            event = state.event,
            opacity = connectionProgress,
            onDetailClick = { intentConsumer(Intent.OnMastermindClick) }
        )

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(spaceHeight))

            LecturesList(
                state = state,
                connection = connection,
                intentConsumer = intentConsumer
            )
        }
    }
}

@Composable
private fun LecturesList(
    modifier: Modifier = Modifier,
    state: State,
    connection: NestedScrollConnection,
    intentConsumer: (Intent) -> Unit,
) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
            .background(
                color = AppColors.neutral0,
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
            )
            .nestedScroll(connection),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        contentPadding = PaddingValues(12.dp)
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.title_lectures_list),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.W800,
                    color = AppColors.neutral90,
                    fontFamily = primaryFontFamily
                )
            }
        }

        items(state.lectures) { lecture ->
            LectureCardNew(
                lecture = lecture,
                onClick = { intentConsumer(Intent.OnLectureClick(lecture)) },
                onFavoriteClick = {  }
            )
        }
    }
}

@Composable
@Preview
private fun LecturesListViewNewPreview() {
    AppTheme {
        LecturesListViewNew(
            state = State.getPreview(),
            intentConsumer = {}
        )
    }
}
