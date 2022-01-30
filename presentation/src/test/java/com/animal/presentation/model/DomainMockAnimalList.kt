package com.animal.presentation.model

import com.animal.domain.entity.Animal

class DomainMockAnimalList {
    fun getAnimalList() = listOf(
        Animal(
            name = "Siamang",
            latin_name = "Hylobates syndactylus",
            animal_type = "Mammal",
            active_time = "Diurnal",
            length_min = "1.90",
            length_max = "2.00",
            weight_min = "20",
            weight_max = "23",
            lifespan = "23",
            habitat = "Tropical rainforest",
            diet = "Primarily fruit and leaves, some invertebrates",
            geo_range = "Malaysia and Sumatra",
            image_link = "https://upload.wikimedia.org/wikipedia/commons/a/a4/DPPP_5348.jpg",
            id = 162
        )
    )

    fun getAnimal() =
        Animal(
            name = "Siamang",
            latin_name = "Hylobates syndactylus",
            animal_type = "Mammal",
            active_time = "Diurnal",
            length_min = "1.90",
            length_max = "2.00",
            weight_min = "20",
            weight_max = "23",
            lifespan = "23",
            habitat = "Tropical rainforest",
            diet = "Primarily fruit and leaves, some invertebrates",
            geo_range = "Malaysia and Sumatra",
            image_link = "https://upload.wikimedia.org/wikipedia/commons/a/a4/DPPP_5348.jpg",
            id = 162
        )

}