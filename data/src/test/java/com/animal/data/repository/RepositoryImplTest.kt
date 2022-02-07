package com.animal.data.repository

import com.animal.domain.extension.Result
import com.animal.data.model.Animal
import com.animal.data.model.MockAnimalList
import com.google.common.truth.Truth
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest

import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class RepositoryImplTest {

    private val coroutineDispatcher = TestCoroutineDispatcher()

    private lateinit var repositoryImpl: RepositoryImpl

    @RelaxedMockK
    private lateinit var remoteDataSource: RemoteSource

    @RelaxedMockK
    private lateinit var localeDataSource: LocalSource

    private lateinit var animalList: List<Animal>

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        repositoryImpl = RepositoryImpl(coroutineDispatcher, remoteDataSource, localeDataSource)
        animalList = MockAnimalList().getAnimalList()
    }

    @Test
    fun testGetItemListOnSuccess() {
        coroutineDispatcher.runBlockingTest {
            coEvery { remoteDataSource.getItemList(1) } returns animalList

            val repo = repositoryImpl.getItemList(1)

            repo.collectLatest {
                if(it is Result.Success) {
                    Truth.assertThat(it.data).isEqualTo(MockAnimalList().getAnimalList())
                }
            }
        }
    }

    @Test
    fun testGetEmptyListOnError() {
        coroutineDispatcher.runBlockingTest {
            coEvery { remoteDataSource.getItemList(1) } returns emptyList()

            val repo = repositoryImpl.getItemList(1)

            repo.collectLatest {
                if(it is Result.Success) {
                    Truth.assertThat(it.data).isEqualTo(emptyList<Animal>())
                }
            }
        }
    }
}