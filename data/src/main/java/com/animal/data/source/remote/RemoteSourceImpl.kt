package com.animal.data.source.remote

import com.animal.data.api.ApiService
import com.animal.data.model.Animal
import com.animal.data.repository.RemoteSource
import javax.inject.Inject

class RemoteSourceImpl @Inject constructor(
    private val apiService: ApiService
): RemoteSource {
    override suspend fun getItemList(number: Int): List<Animal> {
        return apiService.getAnimalList(number)
    }
}