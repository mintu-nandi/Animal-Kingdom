package com.animal.domain.extension

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

sealed class Result<out T> {
    object Loading: Result<Nothing>()
    data class Success<out T>(val data: T): Result<T>()
    data class Error(val error: String): Result<Nothing>()
}

inline fun <T> repoFlow(
    crossinline block: suspend () -> T,
): Flow<Result<T>> = flow {
    try {
        val repoResult = block()
        emit(Result.Success(repoResult))
    } catch (e: Exception) {
        emit(Result.Error(e.message ?: "Unknown error"))
    }
}