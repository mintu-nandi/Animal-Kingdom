package com.animal.data.di

import android.content.Context
import androidx.room.Room
import com.animal.data.api.ApiService
import com.animal.data.api.RetrofitBuilder
import com.animal.data.repository.RepositoryImpl
import com.animal.data.source.local.Dao
import com.animal.data.source.local.Database
import com.animal.data.source.local.LocalSource
import com.animal.data.source.local.LocalSourceImpl
import com.animal.data.source.remote.RemoteSource
import com.animal.data.source.remote.RemoteSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    fun provideApiService(): ApiService =
        RetrofitBuilder.getRetrofit().create(ApiService::class.java)

    @Provides
    fun provideIoDispatcher() = Dispatchers.IO

    @Provides
    fun provideLocalSource(dao: Dao): LocalSourceImpl {
        return LocalSourceImpl(dao)
    }

    @Provides
    fun provideRemoteSource(apiService: ApiService): RemoteSourceImpl {
        return RemoteSourceImpl(apiService)
    }

    @Provides
    fun provideRepository(
        ioDispatcher: CoroutineDispatcher,
        localSource: LocalSource,
        remoteSource: RemoteSource
    ): RepositoryImpl {
        return RepositoryImpl(
            dispatcher = ioDispatcher,
            localSource = localSource,
            remoteSource = remoteSource
        )
    }

    @Provides
    fun provideMoviesDatabase(@ApplicationContext context: Context): Database {
        return Room.databaseBuilder(
            context,
            Database::class.java,
            Database.DATABASE_NAME
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideMovieDao(database: Database): Dao {
        return database.getZooDao()
    }
}