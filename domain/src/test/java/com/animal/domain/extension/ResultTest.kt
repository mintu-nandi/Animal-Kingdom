package com.animal.domain.extension

import com.google.common.truth.Truth
import kotlinx.coroutines.flow.Flow
import org.junit.Test


class ResultTest {
    @Test
    fun `result is loading`() {
        val result = getResult(type = 1)

        Truth.assertThat(result is Result.Loading).isTrue()
    }

    @Test
    fun `result is success`() {
        val result = getResult(type = 2)

        Truth.assertThat(result is Result.Success).isTrue()
        Truth.assertThat((result as Result.Success).data).isEqualTo("Value")
    }

    @Test
    fun `result is error`() {
        val result = getResult(type = 3)

        Truth.assertThat(result is Result.Error).isTrue()
        Truth.assertThat((result as Result.Error).error).isEqualTo("Error")
    }

    @Test
    fun `repoFlow is flow of result`() {
        val repo = repoFlow { getRepoFlow() }
        Truth.assertThat(repo is Flow<Result<String>>).isTrue()
        Truth.assertThat((repo.equals("Repo")))
    }


    private fun getRepoFlow() = "Repo"

    private fun getResult(type: Int): Result<String> {
        return when (type) {
            1 -> {
                Result.Loading
            }
            2 -> {
                Result.Success(data = "Value")
            }
            else -> {
                Result.Error("Error")
            }
        }
    }
}