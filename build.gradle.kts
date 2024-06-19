plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.androidApplication).apply(false)
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinAndroid).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.nativecouroutines) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.skie) apply false
    alias(libs.plugins.realmPlugin) apply false
}

tasks.register<Copy>("copyReleasedFiles") {
//    dependsOn(tasks.named("assembleSharedReleaseXCFramework"))
    dependsOn(":shared:assembleSharedReleaseXCFramework")

    from("shared/build/XCFrameworks/release/shared.xcframework")
    into(File(project.rootDir, "shared.xcframework"))
}
