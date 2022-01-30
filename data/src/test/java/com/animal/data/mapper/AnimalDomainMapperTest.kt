package com.animal.data.mapper

import com.animal.data.model.Animal
import com.animal.domain.entity.Animal as DomainAnimal
import com.animal.data.model.MockAnimalList
import com.animal.data.model.DomainMockAnimalList
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class AnimalDomainMapperTest {

    @RelaxedMockK
    private lateinit var mapper: AnimalDomainMapper

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
        every { mapper.toDomain(animalList) } returns domainAnimalList

        val data = mapper.toDomain(animalList)

        assertEquals(data, domainAnimalList)
    }

    @Test
    fun toDomainItem() {
        every { mapper.toDomain(animalList[0]) } returns domainAnimalList[0]

        val data = mapper.toDomain(animalList[0])

        assertEquals(data, domainAnimalList[0])
    }
}