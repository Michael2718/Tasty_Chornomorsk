package com.example.tastychornomorsk.model

import androidx.annotation.DrawableRes

enum class PlaceCategoryType {
    Restaurant,
    CafeOrCoffeeShop,
    FastFood,
    Pizza,
    Sushi
}


data class PlaceCategory(
    val id: Int,
    val type: PlaceCategoryType,
    @DrawableRes val imageResourceId: Int
)
