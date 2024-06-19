package com.infomaniak.phiphitest.db

import io.realm.kotlin.Realm
import io.realm.kotlin.notifications.ResultsChange
import io.realm.kotlin.query.RealmQuery
import io.realm.kotlin.query.RealmResults
import io.realm.kotlin.query.TRUE_PREDICATE
import io.realm.kotlin.types.RealmObject
import kotlinx.coroutines.flow.Flow
import kotlin.reflect.KClass

internal abstract class RealmController<T : RealmObject>(protected val realm: Realm) {

    abstract val clazz: KClass<T>

    protected fun Realm.query(query: String = TRUE_PREDICATE, vararg args: Any?): RealmQuery<T> {
        return query(clazz, query, args)
    }

    fun findAll(): RealmResults<T> {
        return realm.query().find()
    }

    fun findAllFlow(): Flow<ResultsChange<T>> {
        return realm.query().asFlow()
    }
}
