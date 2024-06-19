package com.infomaniak.phiphitest.db

import com.infomaniak.phiphitest.models.UserRealm
import io.realm.kotlin.Realm
import kotlin.reflect.KClass

internal class UserController(realm: Realm) : RealmController<UserRealm>(realm) {

    override val clazz: KClass<UserRealm> = UserRealm::class

    fun toto() {
        realm.query("")
    }

}
