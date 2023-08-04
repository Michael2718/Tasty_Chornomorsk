package com.example.tastychornomorsk.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.tastychornomorsk.R
import com.example.tastychornomorsk.data.LocalPlacesDataProvider
import com.example.tastychornomorsk.model.Place
import com.example.tastychornomorsk.ui.InfoCard
import com.example.tastychornomorsk.ui.theme.TastyChornomorskTheme

@Composable
private fun PlaceDetail(
    selectedPlace: Place,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    Box(
        modifier = modifier
            .verticalScroll(scrollState)
    ) {
        Column {
            InfoCard {
                Image(
                    painter = painterResource(selectedPlace.imageResourceId),
                    contentDescription = selectedPlace.name,
                    modifier = Modifier
                        .fillMaxWidth(),
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
            InfoCard {
                Column(
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))
                ) {
                    Text(
                        text = selectedPlace.details,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
            InfoCard {
                Row(
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.address),
                        modifier = Modifier.weight(1f),
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = selectedPlace.address,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
            InfoCard {
                Row(
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.link),
                        modifier = Modifier.weight(1f),
                        style = MaterialTheme.typography.titleMedium
                    )
                    val uriHandler = LocalUriHandler.current
                    IconButton(
                        onClick = {
                            uriHandler.openUri(selectedPlace.link)
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.instagram_96),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PlaceDetailPreview() {
    TastyChornomorskTheme {
        Surface {
            PlaceDetail(
                selectedPlace = LocalPlacesDataProvider.getPlacesData()[1],
                onBackPressed = { /*TODO*/ },
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
            )
        }
    }
}