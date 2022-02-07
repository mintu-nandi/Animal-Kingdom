package com.animal.data.repository

import com.animal.data.model.Animal

interface LocalSource {
    suspend fun getItemList(): List<Animal>
    suspend fun addItemList(items: List<Animal>)
}