package com.animal.presentation.mapper

import com.animal.presentation.model.Animal
import com.animal.presentation.model.DomainMockAnimalList
import com.animal.presentation.model.MockAnimalList
import com.animal.domain.entity.Animal as DomainAnimal
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class AnimalUIMapperTest {

    @RelaxedMockK
    private lateinit var mapper: AnimalUIMapper

    private lateinit var animalList: List<Animal>
    private lateinit var domainAnimalList: List<DomainAnimal>

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        animalList = MockAnimalList().getAnimalList()
        domainAnimalList = DomainMockAnimalList().getAnimalList()
    }

    @Test
    fun toDomainList() {
        every { mapper.toUI(domainAnimalList) } returns animalList

        val data = mapper.toUI(domainAnimalList)

        assertEquals(data, animalList)
    }

    @Test
    fun toDomainItem() {
        every { mapper.toUI(domainAnimalList[0]) } returns animalList[0]

        val data = mapper.toUI(domainAnimalList[0])

        assertEquals(data, animalList[0])
    }
}