package com.animal.data.source.local

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.animal.data.model.Animal

@androidx.room.Database(
    entities = [Animal::class],
    version = 1
)

abstract class Database: RoomDatabase() {
    abstract fun getZooDao(): Dao
    companion object {
        const val DATABASE_NAME: String = "zoo_database"
        @Volatile private var instance : Database? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }
        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            Database::class.java,
            DATABASE_NAME
        ).build()
    }
}