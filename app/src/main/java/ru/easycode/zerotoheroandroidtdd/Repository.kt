package ru.easycode.zerotoheroandroidtdd

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

interface Repository {

    suspend fun load()

    class Base() : Repository {

        override suspend fun load() {
            delay(3000)
        }
    }
}