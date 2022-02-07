package com.animal.data.repository

import com.animal.data.model.Animal

interface RemoteSource {
    suspend fun getItemList(number: Int): List<Animal>
}