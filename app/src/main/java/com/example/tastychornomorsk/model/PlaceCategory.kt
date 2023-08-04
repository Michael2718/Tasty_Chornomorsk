package com.example.tastychornomorsk.model

import androidx.annotation.DrawableRes
import com.example.tastychornomorsk.R

enum class PlaceCategoryType {
    Restaurant,
    CafeOrCoffeeShop,
    FastFood,
    Pizza,
    Sushi
}


fun getStringResourceIdFromCategoryEnum(enumValue: PlaceCategoryType): Int {
    return when (enumValue) {
        PlaceCategoryType.Restaurant -> R.string.restaurant
        PlaceCategoryType.CafeOrCoffeeShop -> R.string.cafe_or_coffee_shop
        PlaceCategoryType.FastFood -> R.string.fast_food
        PlaceCategoryType.Pizza -> R.string.pizza
        PlaceCategoryType.Sushi -> R.string.sushi
    }
}

data class PlaceCategory(
    val id: Int,
    val type: PlaceCategoryType,
    val count: Int,
    @DrawableRes val imageResourceId: Int
)
