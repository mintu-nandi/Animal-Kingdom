package com.animal.data.api

import com.animal.data.model.Animal
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("animals/rand/{id}")
    suspend fun getAnimalList(@Path("id") number: Int): List<Animal>
}