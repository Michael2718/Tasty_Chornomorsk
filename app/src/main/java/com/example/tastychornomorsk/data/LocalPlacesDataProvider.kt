package com.example.tastychornomorsk.data

import com.example.tastychornomorsk.R
import com.example.tastychornomorsk.model.Place

object LocalPlacesDataProvider {
    val defaultPlace = getPlacesData()[0]

    fun getPlacesData(): List<Place> {
        return listOf(
            Place(
                id = 1,
                category = PlaceCategory.Restaurant,
                name = "Oslo",
                details = "Гриль-Паб у Чорноморську!\n" +
                        "У нас ви можете чудово провести час\uD83E\uDD18\uD83C\uDFFB\n" +
                        "Смачно поїсти \uD83C\uDF54\n" +
                        "Випити пива\uD83C\uDF7A і не тільки\uD83C\uDF79",
                address = "вул. Данченко 15а",
                link = "https://instagram.com/oslo_pub?igshid=MzRlODBiNWFlZA==",
                linkType = LinkType.Instagram,
                imageResourceId = R.drawable.oslo
            ),
            Place(
                id = 2,
                category = PlaceCategory.Restaurant,
                name = "Afalina",
                details = "\uD83C\uDF0AВсе найкраще з видом на море.\n" +
                        "\uD83C\uDFB6Жива музика.\n" +
                        "\uD83C\uDF82Будь-яке свято.\n" +
                        "\uD83C\uDF79Авторські коктейлі.",
                address = "вул. Пляжна 35",
                link = "https://instagram.com/afalina_restaurant_?igshid=MzRlODBiNWFlZA==",
                linkType = LinkType.Instagram,
                imageResourceId = R.drawable.afalina
            )
        )
    }
}