package com.animal.data.source.remote

import com.animal.data.api.ApiService
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
class RemoteSourceImplTest {

    private lateinit var remoteDataSourceImpl: RemoteSourceImpl

    @RelaxedMockK
    private lateinit var apiService: ApiService

    private lateinit var animalList: List<Animal>

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        remoteDataSourceImpl = RemoteSourceImpl(apiService)
        animalList = MockAnimalList().getAnimalList()
    }

    @Test
    fun getItemListDataSource() {
        runBlockingTest {
            coEvery { remoteDataSourceImpl.getItemList(1) } returns animalList

            val data = remoteDataSourceImpl.getItemList(1)

            assertEquals(data, animalList)
        }
    }
}