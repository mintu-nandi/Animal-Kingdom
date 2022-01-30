package com.animal.data.model

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class AnimalTest {

    private lateinit var animal: Animal

    @Before
    fun setUp() {
        animal = MockAnimalList().getAnimal()
    }

    @Test
    fun getActive_time() {
        val data = animal.copy(active_time = "Diurnal")
        assertEquals(animal.active_time, data.active_time)
    }

    @Test
    fun getAnimal_type() {
        val data = animal.copy(animal_type = "Mammal")
        assertEquals(animal.animal_type, data.animal_type)
    }

    @Test
    fun getDiet() {
        val data = animal.copy(diet = "Primarily fruit and leaves, some invertebrates")
        assertEquals(animal.diet, data.diet)
    }

    @Test
    fun getGeo_range() {
        val data = animal.copy(geo_range = "Malaysia and Sumatra")
        assertEquals(animal.geo_range, data.geo_range)
    }

    @Test
    fun getHabitat() {
        val data = animal.copy(habitat = "Tropical rainforest")
        assertEquals(animal.habitat, data.habitat)
    }

    @Test
    fun getId() {
        val data = animal.copy(id = 162)
        assertEquals(animal.id, data.id)
    }

    @Test
    fun getImage_link() {
        val data = animal.copy(image_link = "https://upload.wikimedia.org/wikipedia/commons/a/a4/DPPP_5348.jpg")
        assertEquals(animal.image_link, data.image_link)
    }

    @Test
    fun getLatin_name() {
        val data = animal.copy(latin_name = "Hylobates syndactylus")
        assertEquals(animal.latin_name, data.latin_name)
    }

    @Test
    fun getLength_max() {
        val data = animal.copy(length_max = "2.00")
        assertEquals(animal.length_max, data.length_max)
    }

    @Test
    fun getLength_min() {
        val data = animal.copy(length_min = "1.90")
        assertEquals(animal.length_min, data.length_min)
    }

    @Test
    fun getLifespan() {
        val data = animal.copy(lifespan = "23")
        assertEquals(animal.lifespan, data.lifespan)
    }

    @Test
    fun getName() {
        val data = animal.copy(name = "Siamang")
        assertEquals(animal.name, data.name)
    }

    @Test
    fun getWeight_max() {
        val data = animal.copy(weight_max = "23")
        assertEquals(animal.weight_max, data.weight_max)
    }

    @Test
    fun getWeight_min() {
        val data = animal.copy(weight_min = "20")
        assertEquals(animal.weight_min, data.weight_min)
    }
}