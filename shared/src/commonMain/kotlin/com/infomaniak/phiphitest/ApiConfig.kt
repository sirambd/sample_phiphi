package com.infomaniak.phiphitest

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.ResponseException
import io.ktor.client.statement.HttpResponse
import io.ktor.utils.io.errors.IOException

internal class ApiConfig {

    val defaultHttpClient = createHttpClient()

    fun createHttpClient(engine: HttpClientEngineFactory<*>? = null): HttpClient {
        val block: HttpClientConfig<*>.() -> Unit = {
//            install(JsonFeature) {
//                serializer = KotlinxSerializer(Json { ignoreUnknownKeys = true })
//            }
//            install(Logging) {
//                level = LogLevel.BODY
//            }
            install(HttpTimeout) {
                requestTimeoutMillis = 10000
                connectTimeoutMillis = 10000
                socketTimeoutMillis = 10000
            }
            HttpResponseValidator {
                validateResponse { response: HttpResponse ->
                    if (response.status.value >= 300) {
                        throw ResponseException(response, "HTTP error: ${response.status.value}")
                    }
                }
                handleResponseExceptionWithRequest { cause, _ ->
                    when (cause) {
                        is IOException -> throw NetworkException("Network error: ${cause.message}")
                        else -> throw cause
                    }
                }
            }
        }

        return if (engine != null) HttpClient(engine, block) else HttpClient(block)
    }
}

class NetworkException(message: String) : IOException(message)
