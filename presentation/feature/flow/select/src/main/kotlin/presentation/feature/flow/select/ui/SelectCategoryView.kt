package presentation.feature.flow.select.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import presentation.feature.flow.select.mvi.Intent
import presentation.feature.flow.select.mvi.State
import presentation.feature.flow.select.mvi.enum.TypeSelect
import presentation.feature.flow.select.ui.component.FlowBox
import presentation.feature.flow.select.ui.component.Toolbar
import presentation.resources.R
import presentation.uikit.component.button.ButtonPrimaryBig
import presentation.uikit.theme.AppColors
import presentation.uikit.theme.AppTheme

@Composable
internal fun SelectCategoryView(
    state: State,
    intentConsumer: (Intent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.neutral100)
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(9.dp)
    ) {
        Toolbar(backClick = { intentConsumer(Intent.onBack) })
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Column {
                LazyVerticalGrid(modifier = Modifier.fillMaxSize(), columns = GridCells.Fixed(2)) {
                    items(state.flows) { flow ->
                        //пока неизвестна реализация как все таки будет, оставлю как есть, потом поправим
                        FlowBox(flow.text, onClick = {}, TypeSelect.SELECTED)
                    }
                }
            }
            ButtonPrimaryBig(
                modifier = Modifier
                    .padding(12.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(AppColors.accent20)
                    .padding(start = 12.dp, end = 12.dp),
                text = stringResource(R.string.category_list_save),
                onClick = {  },
                isEnabled = true,
                isLoading = false
            )
        }
    }
}

@Composable
@Preview(showBackground = true, widthDp = 500, heightDp = 500)
private fun SelectFlowViewPreview() {
    AppTheme {
        Column(
            Modifier
                .height(1900.dp)
                .width(900.dp)
                .background(AppColors.neutral90),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            SelectCategoryView(state = State.getPreview(), intentConsumer = {})
        }
    }
}
