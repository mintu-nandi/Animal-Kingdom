package com.animal.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.animal.domain.extension.Result
import com.animal.domain.usecase.ItemUseCase
import com.animal.domain.entity.Animal as DomainAnimal
import com.animal.presentation.mapper.AnimalUIMapper
import com.animal.presentation.model.DomainMockAnimalList
import com.google.common.truth.Truth
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

@ExperimentalCoroutinesApi
class HomeViewModelTest {
    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private lateinit var viewModel: HomeViewModel


    private lateinit var animalList: List<DomainAnimal>

    @RelaxedMockK
    private lateinit var getUseCase: ItemUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = HomeViewModel(getUseCase)
        animalList = DomainMockAnimalList().getAnimalList()
    }

    @Test
    fun loadingState() {
        testCoroutineRule.runBlockingTest {
            coEvery { getUseCase.invoke(10) } returns flow { emit(Result.Loading) }

            viewModel.getAnimalList()

            Truth.assertThat(viewModel.loadingState.value).isEqualTo(true)
            assertEquals(viewModel.state.value, AnimalUIMapper().toUI(emptyList()))
        }
    }

    @Test
    fun successState() {
        testCoroutineRule.runBlockingTest {
            coEvery { getUseCase.invoke(10) } returns flow {
                emit(Result.Success(animalList))
            }
            viewModel.getAnimalList()

            assertEquals(viewModel.state.value, AnimalUIMapper().toUI(animalList))
            Truth.assertThat(viewModel.loadingState.value).isEqualTo(false)
        }
    }

    @Test
    fun errorState() {
        testCoroutineRule.runBlockingTest {
            coEvery { getUseCase.invoke(10) } returns flow { emit(Result.Error("Error")) }

            viewModel.getAnimalList()

            Truth.assertThat(viewModel.loadingState.value).isEqualTo(false)
            assertEquals(viewModel.errorState.value, "Error")
        }
    }
}