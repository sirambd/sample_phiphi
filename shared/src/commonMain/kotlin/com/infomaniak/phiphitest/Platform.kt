package com.infomaniak.phiphitest

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform