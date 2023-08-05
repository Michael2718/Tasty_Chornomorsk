package com.example.tastychornomorsk.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

enum class LinkType {
    Instagram,
    Website
}

data class Place(
    val id: Int,
    val type: PlaceCategoryType,
    @StringRes val nameResourceId : Int,
    @StringRes val detailsResourceId: Int,
    @StringRes val addressResourceId: Int,
    @StringRes val linkResourceId: Int,
    val linkType: LinkType,
    @DrawableRes val imageResourceId: Int
)