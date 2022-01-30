package com.animal.data.source.local

import com.animal.data.model.Animal
import com.animal.data.model.MockAnimalList
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class LocalSourceImplTest {

    private lateinit var localSourceImpl: LocalSourceImpl

    @RelaxedMockK
    private lateinit var dao: Dao

    private lateinit var animalList: List<Animal>

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        localSourceImpl = LocalSourceImpl(dao)
        animalList = MockAnimalList().getAnimalList()
    }

    @Test
    fun testAddItemList() {
        runBlockingTest {
            coEvery { localSourceImpl.getItemList() } returns animalList

            localSourceImpl.addItemList(animalList)

            val data = localSourceImpl.getItemList()

            assertEquals(data, animalList)
        }
    }
}