package com.example.tastychornomorsk.ui

import com.example.tastychornomorsk.model.Place
import com.example.tastychornomorsk.model.PlaceCategory
import com.example.tastychornomorsk.model.PlaceCategoryType

data class TastyUiState(
    val categoriesList: List<PlaceCategory>,
    val currentCategory: PlaceCategory,
    val placesMap: Map<PlaceCategoryType, List<Place>>,
    val currentPlacesList: List<Place>?,
    val currentPlace: Place?
)
