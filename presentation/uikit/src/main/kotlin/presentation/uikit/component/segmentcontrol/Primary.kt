package presentation.uikit.component.segmentcontrol

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import presentation.uikit.theme.AppColors
import presentation.uikit.theme.AppTheme
import presentation.uikit.theme.AppTypography
import kotlin.math.roundToInt

@Composable
fun <T : Any> SegmentControlPrimary(
    modifier: Modifier = Modifier,
    tabs: ImmutableList<T>,
    selected: T,
    getTabText: @Composable (T) -> String,
    onSelect: (T) -> Unit,
    enabled: Boolean = true
) {
    val tabsSize = remember(tabs) { tabs.size }
    val selectedPos = remember(selected) { tabs.indexOf(selected) }

    val offsetModifier by animateFloatAsState(
        animationSpec = spring(
            dampingRatio = 0.6f,
            stiffness = Spring.StiffnessLow
        ),
        targetValue = selectedPos.toFloat(),
        label = "offset transition"
    )

    Layout(
        modifier = modifier
            .fillMaxWidth()
            .height(46.dp)
            .background(
                color = Color.Transparent,
                shape = RoundedCornerShape(12.dp)
            ),
        content = {
            Tabs(
                tabs = tabs,
                getTabText = getTabText,
                onSelect = onSelect,
                selected = selected
            )

            Indicator()

            DisabledScrim()
        }
    ) { measurables, constraint ->

        val content = measurables[0].measure(constraint)

        val anchor = constraint.minWidth / tabsSize

        val indicator = measurables[1].measure(
            constraint.copy(minWidth = anchor)
        )

        val disabledScrim = measurables.getOrNull(2)?.measure(constraint)

        layout(constraint.maxWidth, constraint.maxHeight) {
            indicator.place((offsetModifier * anchor).roundToInt(), 0)
            content.place(0, 0)
            if (!enabled) disabledScrim?.place(0, 0)
        }
    }
}

@Composable
private fun <T : Any> Tabs(
    tabs: ImmutableList<T>,
    getTabText: @Composable (T) -> String,
    onSelect: (T) -> Unit,
    selected: T,
    enabled: Boolean = true
) {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        tabs.forEach { value ->
            SingleTab(
                weight = 1f / tabs.size,
                value = value,
                getText = getTabText,
                isSelected = value == selected,
                onClick = onSelect,
                enabled = enabled
            )
        }
    }
}

@Composable
private fun <T : Any> RowScope.SingleTab(
    weight: Float,
    value: T,
    isSelected: Boolean,
    getText: @Composable (value: T) -> String,
    onClick: (value: T) -> Unit,
    enabled: Boolean
) {
    val textColor: Color by animateColorAsState(
        if (isSelected) AppColors.neutral0 else AppColors.neutral10
    )

    Text(
        modifier = Modifier
            .weight(weight)
            .clip(RoundedCornerShape(12.dp))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                enabled = enabled && !isSelected,
                onClick = { onClick(value) },
                indication = null
            ),
        text = getText(value),
        color = textColor,
        style = AppTypography.caption.semibold,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun Indicator() {
    Box(
        modifier = Modifier
            .background(
                color = AppColors.neutral90,
                shape = RoundedCornerShape(8.dp)
            )
    )
}

@Composable
private fun DisabledScrim() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable(
                enabled = false,
                onClick = {}
            )
            .background(
                color = Color(0x80000000),
                shape = RoundedCornerShape(12.dp)
            )
    )
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFF)
private fun SegmentControlPrimaryPreview() {
    AppTheme {
        val selectedValue = "Tab1"
        var selected by remember { mutableStateOf(selectedValue) }

        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            SegmentControlPrimary(
                tabs = persistentListOf("Tab1", "Tab2"),
                selected = selected,
                getTabText = { it },
                onSelect = { selected = it }
            )

            SegmentControlPrimary(
                tabs = persistentListOf("Tab1", "Tab2"),
                selected = selectedValue,
                getTabText = { it },
                onSelect = { },
                enabled = false
            )
        }
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFF000000)
private fun SegmentControlPrimaryDarkPreview() {
    AppTheme(true) {
        val selectedValue = "Tab1"
        var selected by remember { mutableStateOf(selectedValue) }

        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            SegmentControlPrimary(
                tabs = persistentListOf("Tab1", "Tab2"),
                selected = selected,
                getTabText = { it },
                onSelect = { selected = it }
            )

            SegmentControlPrimary(
                tabs = persistentListOf("Tab1", "Tab2"),
                selected = selectedValue,
                getTabText = { it },
                onSelect = { },
                enabled = false
            )
        }
    }
}
