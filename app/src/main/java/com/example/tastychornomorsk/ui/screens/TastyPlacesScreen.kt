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
import com.example.tastychornomorsk.data.LocalPlacesDataProvider
import com.example.tastychornomorsk.model.Place
import com.example.tastychornomorsk.model.PlaceCategoryType
import com.example.tastychornomorsk.ui.components.ItemsList
import com.example.tastychornomorsk.ui.theme.TastyChornomorskTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlacesListItem(
    place: Place,
    onItemClick: (Place) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = { onItemClick(place) },
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .size(dimensionResource(R.dimen.card_image_height)),
        ) {
            PlacesListImageItem(
                place = place,
                modifier = Modifier
                    .size(dimensionResource(R.dimen.card_image_height))
            )
            Column(
                modifier = Modifier
                    .padding(
                        vertical = dimensionResource(R.dimen.padding_medium),
                        horizontal = dimensionResource(R.dimen.padding_medium)
                    )
                    .weight(1f)
            ) {
                Text(
                    text = stringResource(place.nameResourceId),
                    modifier = Modifier
                        .padding(bottom = dimensionResource(R.dimen.card_text_vertical_space)),
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = stringResource(place.detailsResourceId),
                    modifier = Modifier
                        .padding(bottom = dimensionResource(R.dimen.card_text_vertical_space)),
//                    color = MaterialTheme.colorScheme.secondary,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodySmall,
                )
            }
        }
    }
}

@Composable
private fun PlacesListImageItem(
    place: Place,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
       Image(
           painter = painterResource(place.imageResourceId),
           contentDescription = stringResource(place.nameResourceId),
           modifier = Modifier.align(Alignment.Center),
           contentScale = ContentScale.Fit
       )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PlacesListItemPreview() {
//    TastyChornomorskTheme {
//        Surface {
//            PlacesListItem(
//                place = LocalPlacesDataProvider.getPlacesData()[1],
//                onItemClick = {}
//            )
//        }
//    }
//}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PlacesListPreview() {
    TastyChornomorskTheme {
        Surface {
            ItemsList(
                items = LocalPlacesDataProvider.getPlacesDataMap()[PlaceCategoryType.Restaurant]!!,
                onClick = {},
            ) { place, onItemClick ->
                PlacesListItem(
                    place = place,
                    onItemClick = onItemClick
                )
            }
        }
    }
}

