package com.infomaniak.phiphitest

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.coroutines.cancellation.CancellationException

class Greeting {
    private val platform: Platform = getPlatform()
    private val apiConfig = ApiConfig()

    private val client inline get() = apiConfig.defaultHttpClient
//    private val client = HttpClient()

    @NativeCoroutinesState
    val totoResult1 = MutableStateFlow("")

    @NativeCoroutinesState
    val totoResult2 = MutableStateFlow("")

    val totoResult3 get() = totoResult2.wrap()

    private val _totoResultSkie = MutableStateFlow("")
    val totoResultSkie: StateFlow<String> = _totoResultSkie

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }

    @NativeCoroutines
    suspend fun toto1(): String {
        val response = client.get("https://ktor.io/docs/")
        val bodyAsText = response.bodyAsText()
        totoResult1.emit(bodyAsText)
        return bodyAsText
    }

    suspend fun toto2(): String {
        val response = client.get("https://ktor.io/docs/")
        val bodyAsText = response.bodyAsText()
        totoResult2.emit(bodyAsText)
        return bodyAsText
    }

    @Throws(CancellationException::class, NetworkException::class)
    suspend fun totoSkie(): String {
        val response = client.get("https://ktor.io/docs/")
        val bodyAsText = response.bodyAsText()
        _totoResultSkie.value = bodyAsText
        return bodyAsText
    }
}
