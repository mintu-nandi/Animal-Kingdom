package com.animal.data.source.local

import com.animal.data.model.Animal
import com.animal.data.repository.LocalSource
import javax.inject.Inject

class LocalSourceImpl @Inject constructor(
    private val zooDao: Dao
): LocalSource {
    override suspend fun getItemList(): List<Animal> {
        return zooDao.getAnimalList()
    }

    override suspend fun addItemList(items: List<Animal>) {
        zooDao.addAnimalList(items)
    }
}