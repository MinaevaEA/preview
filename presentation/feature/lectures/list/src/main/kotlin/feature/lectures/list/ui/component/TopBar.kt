package feature.lectures.list.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import presentation.model.human.EventHuman
import presentation.uikit.theme.AppColors
import presentation.uikit.theme.AppTheme
import presentation.resources.R
import presentation.uikit.component.button.ButtonSecondarySmall
import presentation.uikit.theme.AppTypography

@Composable
internal fun TopBar(
    modifier: Modifier = Modifier,
    event: EventHuman,
    onSelectCategoryClick: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_logo_header),
            contentDescription = "Logo"
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            with(event) {
                Text(
                    text = "$place\n$eventTime",
                    style = AppTypography.captionSmall.medium,
                    lineHeight = 18.sp,
                    color = AppColors.neutral10
                )
            }

            ButtonSecondarySmall(
                text = stringResource(R.string.lectures_list_choose_category),
                onClick = onSelectCategoryClick,
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun TopBarPreview() {
    AppTheme {
        Box(Modifier.background(AppColors.neutral95)) {
            TopBar(
                event = EventHuman.getPreview(),
                onSelectCategoryClick = {}
            )
        }
    }
}
