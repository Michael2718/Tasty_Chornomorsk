package com.example.tastychornomorsk.ui

import com.example.tastychornomorsk.data.PlaceCategory
import com.example.tastychornomorsk.model.Place

data class TastyUiState(
//    val categoriesList: List<>
    val currentCategory: PlaceCategory,
    val placesList: List<Place>,
    val currentPlace: Place
)
