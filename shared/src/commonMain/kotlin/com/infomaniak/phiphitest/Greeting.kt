package com.infomaniak.phiphitest

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.flow.MutableStateFlow

class Greeting {
    private val platform: Platform = getPlatform()
    private val client = HttpClient()

    @NativeCoroutinesState
    val totoResult1 = MutableStateFlow("")

    @NativeCoroutinesState
    val totoResult2 = MutableStateFlow("")

    val totoResult3 get() = totoResult2.wrap()

    val totoResultSkie get() = MutableStateFlow("")

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

    suspend fun totoSkie(): String {
        val response = client.get("https://ktor.io/docs/")
        val bodyAsText = response.bodyAsText()
        totoResultSkie.emit(bodyAsText)
        return bodyAsText
    }
}
