import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

val javaVersion = JavaVersion.VERSION_17

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = javaVersion.toString()
            }
        }
    }

    // Name of the module to be imported in the consumer project
    val xcframeworkName = "shared"
    val xcf = XCFramework(xcframeworkName)

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            // Specify CFBundleIdentifier to uniquely identify the framework
            binaryOption("bundleId", "com.infomaniak.${xcframeworkName}")
            xcf.add(this)
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.infomaniak.phiphitest"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }
}
