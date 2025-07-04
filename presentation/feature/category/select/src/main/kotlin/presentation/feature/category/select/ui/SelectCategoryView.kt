package presentation.feature.category.select.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
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
import presentation.feature.category.select.mvi.Intent
import presentation.feature.category.select.mvi.State
import presentation.feature.category.select.mvi.enum.TypeSelect
import presentation.feature.category.select.ui.component.CategoryItem
import presentation.feature.category.select.ui.component.Toolbar
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
                    items(state.category) { category ->
                        //пока неизвестна реализация как все таки будет, оставлю как есть, потом поправим
                        CategoryItem(category.category, onClick = {}, TypeSelect.SELECTED)
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
                .background(AppColors.neutral90),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            SelectCategoryView(state = State.getPreview(), intentConsumer = {})
        }
    }
}
