package com.infomaniak.phiphitest.db

import com.infomaniak.phiphitest.models.UserRealm
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

internal class RealmProvider {

    private val realmConfiguration = RealmConfiguration.create(
        schema = setOf(UserRealm::class)
    )

    val realm by lazy { Realm.open(realmConfiguration) }

    fun close() {
        realm.close()
    }

}
