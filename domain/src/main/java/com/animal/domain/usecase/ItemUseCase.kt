package com.animal.domain.usecase

import com.animal.domain.entity.Animal
import com.animal.domain.repository.Repository
import com.animal.domain.extension.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ItemUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(number: Int): Flow<Result<List<Animal>>> =
        repository.getItemList(number)
}