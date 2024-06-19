package com.infomaniak.phiphitest.models

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class UserRealm : RealmObject, User {
    @PrimaryKey
    var _id: ObjectId = ObjectId()
    override var name: String = ""
    override var age: Long = 0
}
