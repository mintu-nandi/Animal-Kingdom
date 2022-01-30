package com.animal.data.source.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.animal.data.model.Animal
import com.animal.data.model.MockAnimalLists
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(AndroidJUnit4::class)
class DaoTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: Database
    private lateinit var dao: Dao
    private lateinit var animalList: List<Animal>

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            Database::class.java
        ).allowMainThreadQueries().build()

        dao = database.getZooDao()
        animalList = MockAnimalLists().getAnimalList()
    }

    @After
    @Throws(IOException::class)
    fun teardown() {
         database.close()
    }

    @Test
    @Throws(Exception::class)
    fun testAddAnimalList() = runBlockingTest {
        dao.addAnimalList(animalList)

        val data = dao.getAnimalList()

        assertThat(data).contains(animalList[0])
    }
}