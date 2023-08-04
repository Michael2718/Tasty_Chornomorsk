package com.example.tastychornomorsk.model

import androidx.annotation.DrawableRes

enum class LinkType {
    Instagram,
    Website
}

data class Place(
    val id: Int,
    val type: PlaceCategoryType,
    val name : String,
    val details: String,
    val address: String,
    val link: String,
    val linkType: LinkType,
    @DrawableRes val imageResourceId: Int
)