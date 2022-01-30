package com.animal.presentation.di

import com.animal.domain.repository.Repository
import com.animal.domain.usecase.ItemUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PresentationModule {

    @Provides
    fun provideItemUseCase(repository: Repository): ItemUseCase {
        return ItemUseCase(repository)
    }
}