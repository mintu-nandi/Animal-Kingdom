package com.animal.data.repository

import com.animal.data.mapper.ZooDomainMapper
import com.animal.data.source.local.LocalSource
import com.animal.data.source.remote.RemoteSource
import com.animal.domain.extension.repoFlow
import com.animal.domain.repository.Repository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val remoteSource: RemoteSource,
    private val localSource: LocalSource
): Repository {
    override suspend fun getItemList(number: Int) = repoFlow {
        try {
            val data = remoteSource.getItemList(number)
            if (data.isNotEmpty()) {
                localSource.addItemList(data)
            }
            ZooDomainMapper().toDomain(localSource.getItemList())
        } catch (e: Exception) {
            ZooDomainMapper().toDomain(localSource.getItemList())
        }
    }.flowOn(dispatcher)

}