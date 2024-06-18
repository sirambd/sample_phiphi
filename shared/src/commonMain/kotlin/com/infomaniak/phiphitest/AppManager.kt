package com.infomaniak.phiphitest

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.coroutines.cancellation.CancellationException

class AppManager internal constructor(private val httpClient: HttpClient) {

    private val _testResult = MutableStateFlow("")
    val testResultFlow: StateFlow<String> = _testResult

    constructor() : this(ApiConfig().createHttpClient())

    @Throws(NetworkException::class, CancellationException::class)
    suspend fun testCall() {
        val response = httpClient.get("https://ktor.io/docs/")
        val bodyAsText = response.bodyAsText()
        _testResult.emit(bodyAsText)
    }
}
