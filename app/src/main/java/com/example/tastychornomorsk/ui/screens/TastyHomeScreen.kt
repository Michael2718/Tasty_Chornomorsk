package com.example.tastychornomorsk.ui.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tastychornomorsk.R
import com.example.tastychornomorsk.ui.TastyViewModel
import com.example.tastychornomorsk.ui.components.ItemsList
import com.example.tastychornomorsk.ui.theme.TastyChornomorskTheme

enum class TastyScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    Places(title = R.string.places),
    Place(title = R.string.place)
}

@Composable
fun TastyChornomorskApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
    viewModel: TastyViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = TastyScreen.valueOf(
        backStackEntry?.destination?.route ?: TastyScreen.Start.name
    )

    // ContentType

    val uiState by viewModel.uiState.collectAsState()
    Scaffold(
        topBar = {
            TastyAppBar(
                currentScreen = currentScreen,
                uiState.currentPlace!!.nameResourceId,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
                windowSize = windowSize
            )
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = TastyScreen.Start.name,
            modifier = modifier.padding(innerPadding)
        ) {
            composable(TastyScreen.Start.name) {
                ItemsList(
                    items = uiState.categoriesList,
                    onClick = {
                        viewModel.updateCurrentCategory(it)
                        navController.navigate(TastyScreen.Places.name)
                    }
                ) { category, onItemClick ->
                    CategoryListItem(
                        category = category,
                        onItemClick = onItemClick
                    )
                }
            }
            composable(TastyScreen.Places.name) {
                ItemsList(
                    items = uiState.currentPlacesList!!, // TODO: Getting different lists(map?) from viewModel
                    onClick = {
                        viewModel.updateCurrentPlace(it)
                        navController.navigate(TastyScreen.Place.name)
                    }
                ) { place, onItemClick ->
                    PlacesListItem(
                        place = place,
                        onItemClick = onItemClick
                    )
                }
            }
            composable(TastyScreen.Place.name) {
                PlaceDetail(
                    selectedPlace = uiState.currentPlace!!
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TastyAppBar(
    currentScreen: TastyScreen,
    @StringRes currentPlaceNameResourceId: Int,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text = when (currentScreen) {
                    TastyScreen.Place -> stringResource(currentPlaceNameResourceId)
                    else -> stringResource(currentScreen.title)
                },
                color = MaterialTheme.colorScheme.surface,
                fontWeight = FontWeight.Bold
            )
        },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack && windowSize != WindowWidthSizeClass.Expanded) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = Color.Green,
            navigationIconContentColor = MaterialTheme.colorScheme.surface,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}

@Preview(showBackground = true)
@Composable
fun SportsAppCompactLightPreview() {
    TastyChornomorskTheme {
        Surface {
            TastyChornomorskApp(
                windowSize = WindowWidthSizeClass.Compact
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SportsAppCompactDarkPreview() {
    TastyChornomorskTheme(darkTheme = true) {
        Surface {
            TastyChornomorskApp(
                windowSize = WindowWidthSizeClass.Compact
            )
        }
    }
}