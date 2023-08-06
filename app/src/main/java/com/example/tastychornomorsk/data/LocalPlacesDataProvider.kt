package com.example.tastychornomorsk.data

import com.example.tastychornomorsk.R
import com.example.tastychornomorsk.model.LinkType
import com.example.tastychornomorsk.model.Place
import com.example.tastychornomorsk.model.PlaceCategoryType

fun main() {
    val map = LocalPlacesDataProvider.getPlacesDataMap()
    println(map[PlaceCategoryType.Restaurant])
}

object LocalPlacesDataProvider {
    val defaultPlacesList = getPlacesDataMap()[PlaceCategoryType.Restaurant]
    val defaultPlace = defaultPlacesList?.get(0)

    fun getPlacesDataMap(): Map<PlaceCategoryType, List<Place>> {
        return getPlacesDataList().groupBy { it.type }
    }

    private fun getPlacesDataList(): List<Place> {
        return listOf(
            Place(
                id = 1,
                type = PlaceCategoryType.Restaurant,
                nameResourceId = R.string.places_oslo_name,
                detailsResourceId = R.string.places_oslo_details,
                addressResourceId = R.string.places_oslo_address,
                linkResourceId = R.string.places_oslo_link,
                linkType = LinkType.Instagram,
                imageResourceId = R.drawable.places_oslo
            ),
            Place(
                id = 2,
                type = PlaceCategoryType.Restaurant,
                nameResourceId = R.string.places_afalina_name,
                detailsResourceId = R.string.places_afalina_details,
                addressResourceId = R.string.places_afalina_address,
                linkResourceId = R.string.places_afalina_link,
                linkType = LinkType.Instagram,
                imageResourceId = R.drawable.places_afalina
            ),
            Place(
                id = 3,
                type = PlaceCategoryType.Restaurant,
                nameResourceId = R.string.places_metropolis_terrace_name,
                detailsResourceId = R.string.places_metropolis_terrace_details,
                addressResourceId = R.string.places_metropolis_terrace_address,
                linkResourceId = R.string.places_metropolis_terrace_link,
                linkType = LinkType.Instagram,
                imageResourceId = R.drawable.places_afalina
            ),
            Place(
                id = 4,
                type = PlaceCategoryType.CafeOrCoffeeShop,
                nameResourceId = R.string.places_milen_name,
                detailsResourceId = R.string.places_milen_details,
                addressResourceId = R.string.places_milen_address,
                linkResourceId = R.string.places_milen_link,
                linkType = LinkType.Instagram,
                imageResourceId = R.drawable.places_afalina
            ),
            Place(
                id = 5,
                type = PlaceCategoryType.CafeOrCoffeeShop,
                nameResourceId = R.string.places_polunitsa_name,
                detailsResourceId = R.string.places_polunitsa_details,
                addressResourceId = R.string.places_polunitsa_address,
                linkResourceId = R.string.places_polunitsa_link,
                linkType = LinkType.Instagram,
                imageResourceId = R.drawable.places_afalina
            ),
            Place(
                id = 6,
                type = PlaceCategoryType.CafeOrCoffeeShop,
                nameResourceId = R.string.places_all_day_name,
                detailsResourceId = R.string.places_all_day_details,
                addressResourceId = R.string.places_all_day_address,
                linkResourceId = R.string.places_all_day_link,
                linkType = LinkType.Instagram,
                imageResourceId = R.drawable.places_afalina
            ),
            Place(
                id = 7,
                type = PlaceCategoryType.FastFood,
                nameResourceId = R.string.places_smachna_hata_name,
                detailsResourceId = R.string.places_smachna_hata_details,
                addressResourceId = R.string.places_smachna_hata_address,
                linkResourceId = R.string.places_smachna_hata_link,
                linkType = LinkType.Website,
                imageResourceId = R.drawable.places_afalina
            ),
            Place(
                id = 8,
                type = PlaceCategoryType.FastFood,
                nameResourceId = R.string.places_street_chef_name,
                detailsResourceId = R.string.places_street_chef_details,
                addressResourceId = R.string.places_street_chef_address,
                linkResourceId = R.string.places_street_chef_link,
                linkType = LinkType.Instagram,
                imageResourceId = R.drawable.places_afalina
            ),
            Place(
                id = 9,
                type = PlaceCategoryType.FastFood,
                nameResourceId = R.string.places_pepper_point_name,
                detailsResourceId = R.string.places_pepper_point_details,
                addressResourceId = R.string.places_pepper_point_address,
                linkResourceId = R.string.places_pepper_point_link,
                linkType = LinkType.Instagram,
                imageResourceId = R.drawable.places_afalina
            ),
            Place(
                id = 10,
                type = PlaceCategoryType.Pizza,
                nameResourceId = R.string.places_pizza_na_drovah_pich_name,
                detailsResourceId = R.string.places_pizza_na_drovah_pich_details,
                addressResourceId = R.string.places_pizza_na_drovah_pich_address,
                linkResourceId = R.string.places_pizza_na_drovah_pich_link,
                linkType = LinkType.Instagram,
                imageResourceId = R.drawable.places_afalina
            ),
            Place(
                id = 11,
                type = PlaceCategoryType.Pizza,
                nameResourceId = R.string.places_dominos_pizza_name,
                detailsResourceId = R.string.places_dominos_pizza_details,
                addressResourceId = R.string.places_dominos_pizza_address,
                linkResourceId = R.string.places_dominos_pizza_link,
                linkType = LinkType.Website,
                imageResourceId = R.drawable.places_afalina
            ),
            Place(
                id = 12,
                type = PlaceCategoryType.Pizza,
                nameResourceId = R.string.places_zhar_pizza_name,
                detailsResourceId = R.string.places_zhar_pizza_details,
                addressResourceId = R.string.places_zhar_pizza_address,
                linkResourceId = R.string.places_zhar_pizza_link,
                linkType = LinkType.Instagram,
                imageResourceId = R.drawable.places_afalina
            ),
            Place(
                id = 13,
                type = PlaceCategoryType.Sushi,
                nameResourceId = R.string.places_osama_name,
                detailsResourceId = R.string.places_osama_details,
                addressResourceId = R.string.places_osama_address,
                linkResourceId = R.string.places_osama_link,
                linkType = LinkType.Instagram,
                imageResourceId = R.drawable.places_afalina
            ),
            Place(
                id = 14,
                type = PlaceCategoryType.Sushi,
                nameResourceId = R.string.places_budusushi_name,
                detailsResourceId = R.string.places_budusushi_details,
                addressResourceId = R.string.places_budusushi_address,
                linkResourceId = R.string.places_budusushi_link,
                linkType = LinkType.Instagram,
                imageResourceId = R.drawable.places_afalina
            ),
            Place(
                id = 15,
                type = PlaceCategoryType.Sushi,
                nameResourceId = R.string.places_sushizoom_name,
                detailsResourceId = R.string.places_sushizoom_details,
                addressResourceId = R.string.places_sushizoom_address,
                linkResourceId = R.string.places_sushizoom_link,
                linkType = LinkType.Instagram,
                imageResourceId = R.drawable.places_afalina
            )
        )
    }

    fun getPlacesListSizeByType(type: PlaceCategoryType): Int {
        return getPlacesDataMap()[type]!!.size
    }
}