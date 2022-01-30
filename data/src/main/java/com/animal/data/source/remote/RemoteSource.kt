package com.animal.data.source.remote

import com.animal.data.model.Animal

interface RemoteSource {
    suspend fun getItemList(number: Int): List<Animal>
}