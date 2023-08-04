package com.example.tastychornomorsk.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tastychornomorsk.R
import com.example.tastychornomorsk.data.LocalPlaceCategoriesDataProvider
import com.example.tastychornomorsk.model.PlaceCategory
import com.example.tastychornomorsk.model.getStringResourceIdFromCategoryEnum
import com.example.tastychornomorsk.ui.components.ItemsList
import com.example.tastychornomorsk.ui.theme.TastyChornomorskTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryListItem(
    category: PlaceCategory,
    onItemClick: (PlaceCategory) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = { onItemClick(category) },
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .size(dimensionResource(R.dimen.card_image_height))
        ) {
            CategoryListImageItem(
                category = category,
                modifier = Modifier.size(dimensionResource(R.dimen.card_image_height))
            )
            Column(
                modifier = Modifier
                    .padding(
                        vertical = dimensionResource(R.dimen.padding_small),
                        horizontal = dimensionResource(R.dimen.padding_medium)
                    )
                    .weight(1f)
            ) {
                Text(
                    text = stringResource(
                        getStringResourceIdFromCategoryEnum(category.type)
                    ),
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = dimensionResource(R.dimen.card_text_vertical_space))
                )
                Text(
                    text = stringResource(R.string.places_count, category.count),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
private fun CategoryListImageItem(
    category: PlaceCategory,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(category.imageResourceId),
            contentDescription = category.type.toString(),
            modifier = Modifier.align(Alignment.Center),
            contentScale = ContentScale.Fit
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryListItemPreview() {
    TastyChornomorskTheme {
        Surface {
            CategoryListItem(
                category = LocalPlaceCategoriesDataProvider.getPlaceCategoriesData()[0],
                onItemClick = {}
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CategoryListPreview() {
    TastyChornomorskTheme {
        Surface {
            ItemsList(
                items = LocalPlaceCategoriesDataProvider.getPlaceCategoriesData(),
                onClick = {},
            ) { category, onItemClick ->
                CategoryListItem(
                    category = category,
                    onItemClick = onItemClick
                )
            }
        }
    }
}
