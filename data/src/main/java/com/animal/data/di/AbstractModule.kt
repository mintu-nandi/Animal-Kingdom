package com.animal.data.di

import com.animal.data.repository.RepositoryImpl
import com.animal.data.repository.LocalSource
import com.animal.data.source.local.LocalSourceImpl
import com.animal.data.repository.RemoteSource
import com.animal.data.source.remote.RemoteSourceImpl
import com.animal.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AbstractModule {

    @Binds
    abstract fun bindRepository(repositoryImpl: RepositoryImpl): Repository

    @Binds
    abstract fun bindLocalSource(localSourceImpl: LocalSourceImpl): LocalSource

    @Binds
    abstract fun bindRemoteSource(remoteSourceImpl: RemoteSourceImpl): RemoteSource
}