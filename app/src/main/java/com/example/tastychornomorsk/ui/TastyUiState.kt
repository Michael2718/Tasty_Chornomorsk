package com.example.tastychornomorsk.ui

import com.example.tastychornomorsk.model.Place
import com.example.tastychornomorsk.model.PlaceCategory

data class TastyUiState(
    val categoriesList: List<PlaceCategory>,
    val currentCategory: PlaceCategory,
    val placesList: List<Place>,
    val currentPlace: Place
)
