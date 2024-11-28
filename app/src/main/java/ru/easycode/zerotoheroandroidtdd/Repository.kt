package ru.easycode.zerotoheroandroidtdd

import java.net.ConnectException
import java.net.UnknownHostException

interface Repository {
    suspend fun load() : LoadResult

    class Base(
        private val service: SimpleService,
        private val url: String
    ) : Repository {
        override suspend fun load() : LoadResult {
            try {
                val response = service.fetch(url)
                return LoadResult.Success(response)
            } catch (e: Exception) {
                return if (e is UnknownHostException || e is ConnectException) {
                    LoadResult.Error(true)
                } else {
                    LoadResult.Error(false)
                }
            }
        }
    }
}