package com.example.tastychornomorsk.model

import androidx.annotation.DrawableRes
import com.example.tastychornomorsk.data.LinkType
import com.example.tastychornomorsk.data.PlaceCategory

data class Place(
    val id: Int,
    val category: PlaceCategory,
    val name : String,
    val details: String,
    val address: String,
    val link: String,
    val linkType: LinkType,
    @DrawableRes val imageResourceId: Int
)