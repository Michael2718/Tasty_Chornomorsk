package com.example.tastychornomorsk.ui

import androidx.lifecycle.ViewModel
import com.example.tastychornomorsk.data.LocalPlaceCategoriesDataProvider
import com.example.tastychornomorsk.data.LocalPlacesDataProvider
import com.example.tastychornomorsk.model.Place
import com.example.tastychornomorsk.model.PlaceCategory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class TastyViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(
        TastyUiState(
            categoriesList = LocalPlaceCategoriesDataProvider.getPlaceCategoriesData(),
            currentCategory = LocalPlaceCategoriesDataProvider.defaultCategory,
            placesMap = LocalPlacesDataProvider.getPlacesDataMap(),
            currentPlacesList = LocalPlacesDataProvider.defaultPlacesList,
            currentPlace = LocalPlacesDataProvider.defaultPlace
        )
    )
    val uiState: StateFlow<TastyUiState> = _uiState

    fun updateCurrentCategory(selectedCategory: PlaceCategory) {
        _uiState.update {
            it.copy(
                currentCategory = selectedCategory,
                currentPlacesList = it.placesMap[selectedCategory.type]
            )
        }
    }

    fun updateCurrentPlace(selectedPlace: Place) {
        _uiState.update {
            it.copy(currentPlace = selectedPlace)
        }
    }
}