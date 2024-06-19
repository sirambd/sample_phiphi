package com.infomaniak.phiphitest

import com.infomaniak.phiphitest.db.RealmProvider
import com.infomaniak.phiphitest.db.UserController
import com.infomaniak.phiphitest.models.User
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.realm.kotlin.Realm
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.coroutines.cancellation.CancellationException

class AppManager internal constructor(private val httpClient: HttpClient, private val realm: Realm) {

    private val _testResult = MutableStateFlow("")
    val testResultFlow: StateFlow<String> = _testResult

    private val userController = UserController(realm)

    constructor() : this(
        httpClient = ApiConfig().createHttpClient(),
        realm = RealmProvider().realm,
    )

    @Throws(NetworkException::class, CancellationException::class)
    suspend fun testCall() {
        val response = httpClient.get("https://ktor.io/docs/")
        val bodyAsText = response.bodyAsText()
        _testResult.emit(bodyAsText)
    }

    fun getAllRealmUsers(): List<User> = userController.findAll()
}
