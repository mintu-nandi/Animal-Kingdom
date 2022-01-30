package com.animal.presentation.viewmodel

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.animal.domain.extension.Result
import com.animal.domain.usecase.ItemUseCase
import com.animal.presentation.mapper.AnimalUIMapper
import com.animal.presentation.model.Animal
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: ItemUseCase
): ViewModel() {

    init {
        getAnimalList()
    }

    private val _state: MutableStateFlow<List<Animal>> = MutableStateFlow(emptyList())
    val state: StateFlow<List<Animal>> = _state

    private val _loadingState = MutableStateFlow(true)
    val loadingState: StateFlow<Boolean> = _loadingState

    private val _errorState = MutableStateFlow("")
    val errorState: StateFlow<String> = _errorState

    @VisibleForTesting
    internal fun getAnimalList(number: Int = 10) = viewModelScope.launch {
        useCase.invoke(number).collectLatest {
            when(it) {
                is Result.Loading -> {
                    _loadingState.value = true
                }
                is Result.Success -> {
                    _loadingState.value = false
                    _state.value = AnimalUIMapper().toUI(it.data)
                }
                is Result.Error -> {
                    _loadingState.value = false
                    _errorState.value = it.error
                }
            }
        }
    }

    fun refresh() = getAnimalList()
}