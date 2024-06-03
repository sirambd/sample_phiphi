package com.infomaniak.phiphitest

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.flow.MutableStateFlow

class Greeting {
    private val platform: Platform = getPlatform()
    private val client = HttpClient()

    val totoResult = MutableStateFlow("")

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }

    suspend fun toto(): String {
        val response = client.get("https://ktor.io/docs/")
        val bodyAsText = response.bodyAsText()
        totoResult.emit(bodyAsText)
        return bodyAsText
    }
}
