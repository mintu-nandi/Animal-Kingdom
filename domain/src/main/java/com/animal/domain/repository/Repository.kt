package com.animal.domain.repository

import com.animal.domain.entity.Animal
import kotlinx.coroutines.flow.Flow
import com.animal.domain.extension.Result

interface Repository {
    suspend fun getItemList(number: Int): Flow<Result<List<Animal>>>
}