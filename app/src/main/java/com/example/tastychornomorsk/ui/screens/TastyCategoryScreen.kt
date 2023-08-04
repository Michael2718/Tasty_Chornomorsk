package com.example.tastychornomorsk.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tastychornomorsk.R
import com.example.tastychornomorsk.model.Place
import com.example.tastychornomorsk.model.PlaceCategory
import com.example.tastychornomorsk.ui.TastyViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TastyChornomorskApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    val viewModel: TastyViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    // ContentType

//    Scaffold(
//        topBar = {
//            TastyAppBar(
//                onBackButtonClick = { /*TODO*/ },
//                windowSize = windowSize
//            )
//        }
//    ) { innerPadding ->
//
//    }
}

@Composable
fun PlacesCategoryList(
    categories: List<PlaceCategory>,
    onClick: (PlaceCategory) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding_medium)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
        modifier = modifier
    ) {
        items(categories, key = { category -> category.id }) {category ->
//            PlacesCategoryItem(
//                category = category,
//                onItemClick = onClick
//            )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CategoryListItem(
    category: PlaceCategory,
    onItemClick: (PlaceCategory) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = { onItemClick(category) },
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    ) {
/*        Row(
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
                    text = place.name,
                    modifier = Modifier
                        .padding(bottom = dimensionResource(R.dimen.card_text_vertical_space)),
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = place.details,
                    modifier = Modifier
                        .padding(bottom = dimensionResource(R.dimen.card_text_vertical_space)),
                    color = MaterialTheme.colorScheme.secondary,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodySmall,
                )
            }
        }*/

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

@Composable
fun TastyAppBar(
    onBackButtonClick: () -> Unit,
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {

}