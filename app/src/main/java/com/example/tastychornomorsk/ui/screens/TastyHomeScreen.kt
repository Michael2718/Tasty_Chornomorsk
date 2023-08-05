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
import com.example.tastychornomorsk.ui.components.ItemsList
import com.example.tastychornomorsk.ui.TastyViewModel
import com.example.tastychornomorsk.ui.theme.TastyChornomorskTheme

enum class TastyScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    Places(title = R.string.places),
    Place(title = R.string.place)
}

@OptIn(ExperimentalMaterial3Api::class)
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

    Scaffold(
        topBar = {
            TastyAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
                windowSize = windowSize
            )
        }
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

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
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(currentScreen.title),
                fontWeight = FontWeight.Bold
            )
        },
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
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary
        ),
        modifier = modifier
    )
}

@Preview(showBackground = true, locale = "uk")
@Composable
fun SportsAppCompactPreview() {
    TastyChornomorskTheme {
        Surface {
            TastyChornomorskApp(
                windowSize = WindowWidthSizeClass.Compact
            )
        }
    }
}