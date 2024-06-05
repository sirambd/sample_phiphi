package com.infomaniak.phiphitest

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class CFlow<T>(private val origin: Flow<T>) : Flow<T> by origin {
    fun watch(block: (T) -> Unit): AutoCloseable {
        val job = Job()

        onEach {
            block(it)
        }.launchIn(CoroutineScope(Dispatchers.Main + job))

        return object : AutoCloseable {
            override fun close() {
                job.cancel()
            }
        }
    }
}

// Helper extension
internal fun <T> Flow<T>.wrap(): CFlow<T> = CFlow(this)
