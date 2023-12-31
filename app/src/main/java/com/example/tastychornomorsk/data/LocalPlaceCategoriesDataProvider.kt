package com.example.tastychornomorsk.data

import com.example.tastychornomorsk.R
import com.example.tastychornomorsk.model.PlaceCategory
import com.example.tastychornomorsk.model.PlaceCategoryType

object LocalPlaceCategoriesDataProvider {
    val defaultCategory = getPlaceCategoriesData()[0]
    fun getPlaceCategoriesData(): List<PlaceCategory> {
        return listOf(
            PlaceCategory(
                1,
                PlaceCategoryType.Restaurant,
                LocalPlacesDataProvider.getPlacesListSizeByType(PlaceCategoryType.Restaurant),
                R.drawable.categories_restaurant,
            ),
            PlaceCategory(
                2,
                PlaceCategoryType.CafeOrCoffeeShop,
                LocalPlacesDataProvider.getPlacesListSizeByType(PlaceCategoryType.CafeOrCoffeeShop),
                R.drawable.categories_cafe_or_coffee_shop
            ),
            PlaceCategory(
                3,
                PlaceCategoryType.FastFood,
                LocalPlacesDataProvider.getPlacesListSizeByType(PlaceCategoryType.FastFood),
                R.drawable.categories_fast_food
            ),
            PlaceCategory(
                4,
                PlaceCategoryType.Pizza,
                LocalPlacesDataProvider.getPlacesListSizeByType(PlaceCategoryType.Pizza),
                R.drawable.categories_pizza
            ),
            PlaceCategory(
                5,
                PlaceCategoryType.Sushi,
                LocalPlacesDataProvider.getPlacesListSizeByType(PlaceCategoryType.Sushi),
                R.drawable.categories_sushi
            )
        )
    }
}