package com.animal.data.mapper

import androidx.annotation.VisibleForTesting
import com.animal.domain.entity.Animal as DomainAnimal
import com.animal.data.model.Animal as DataAnimal

internal class AnimalDomainMapper {

    fun toDomain(list: List<DataAnimal>): List<DomainAnimal> {
        return list.map { toDomain(it) }
    }

    @VisibleForTesting
    internal fun toDomain(animal: DataAnimal): DomainAnimal {
        return DomainAnimal(
         active_time = animal.active_time,
         animal_type = animal.animal_type,
         diet = animal.diet,
         geo_range = animal.geo_range,
         habitat = animal.habitat,
         id = animal.id,
         image_link = animal.image_link,
         latin_name = animal.latin_name,
         length_max = animal.length_max,
         length_min = animal.length_min,
         lifespan = animal.lifespan,
         name = animal.name,
         weight_max = animal.weight_max,
         weight_min = animal.weight_min
        )
    }
}