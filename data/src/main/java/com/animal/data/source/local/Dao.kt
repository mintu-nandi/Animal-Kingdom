package com.animal.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.animal.data.model.Animal

@Dao
interface Dao {
    @Query("SELECT * FROM zoo ORDER BY name ASC")
    suspend fun getAnimalList(): List<Animal>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAnimalList(animals: List<Animal>)
}