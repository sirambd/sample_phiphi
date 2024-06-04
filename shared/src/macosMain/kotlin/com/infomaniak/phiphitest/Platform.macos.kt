package com.infomaniak.phiphitest

class MacOSPlatform : Platform {
    override val name: String = "macOS"
}

actual fun getPlatform(): Platform = MacOSPlatform()
