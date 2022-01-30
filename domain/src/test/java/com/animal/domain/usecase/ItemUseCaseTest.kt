package com.animal.domain.usecase

import com.animal.domain.entity.Animal
import com.animal.domain.entity.MockAnimalList
import com.animal.domain.repository.Repository
import com.animal.domain.extension.Result
import com.google.common.truth.Truth
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class ItemUseCaseTest {
    @RelaxedMockK
    lateinit var repo: Repository

    private lateinit var useCase: ItemUseCase
    private lateinit var animalList: List<Animal>

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        useCase = ItemUseCase(repo)
        animalList = MockAnimalList().getAnimalList()
    }

    @OptIn(InternalCoroutinesApi::class)
    @Test
    fun `flow is success result movies`() {
        runBlocking {
            coEvery { repo.getItemList(1) } returns flow { emit(Result.Success(animalList)) }

            val data =  useCase.invoke(1)

            coVerify { useCase.invoke(1) }

            data.collectLatest {
                Truth.assertThat(it is Result.Success).isTrue()
            }
        }
    }

    @Test
    fun `flow is loading result movies`() {
        runBlocking {
            coEvery { repo.getItemList(1) } returns flow { emit(Result.Loading) }

            val data =  useCase.invoke(1)

            coVerify { useCase.invoke(1) }

            data.collectLatest { result ->
                Truth.assertThat(result is Result.Loading).isTrue()
            }
        }
    }

    @Test
    fun `flow is error result movies`() {
        runBlocking {
            coEvery { repo.getItemList(1) } returns flow { emit(Result.Error("Error")) }

            val data =  useCase.invoke(1)

            coVerify { useCase.invoke(1) }

            data.collectLatest { result ->
                Truth.assertThat(result is Result.Error).isTrue()
            }
        }
    }
}