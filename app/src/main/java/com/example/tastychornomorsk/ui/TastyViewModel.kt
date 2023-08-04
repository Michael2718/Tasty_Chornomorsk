package com.example.tastychornomorsk.ui

import androidx.lifecycle.ViewModel
import com.example.tastychornomorsk.data.LocalPlacesDataProvider
import com.example.tastychornomorsk.data.PlaceCategory
import com.example.tastychornomorsk.model.Place
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class TastyViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(
        TastyUiState(
            currentCategory = PlaceCategory.Restaurant, // TODO: Change
            placesList = LocalPlacesDataProvider.getPlacesData(),
            currentPlace = LocalPlacesDataProvider.getPlacesData().getOrElse(0) {
                LocalPlacesDataProvider.defaultPlace
            }
        )
    )
    val uiState: StateFlow<TastyUiState> = _uiState

    fun updateCurrentPlace(selectedPlace: Place) {
        _uiState.update {
            it.copy(currentPlace = selectedPlace)
        }
    }
}