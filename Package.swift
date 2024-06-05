// swift-tools-version:5.10
import PackageDescription

let package = Package(
    name: "Shared",
    platforms: [
        .iOS(.v14),
        .macOS(.v11)
    ],
    products: [
        .library(name: "Shared", targets: ["Shared"]),
        .library(name: "Shared-Dep", targets: ["Dependencies"])
    ],
    dependencies: [
        .package(url: "https://github.com/rickclephas/KMP-NativeCoroutines.git", exact: "1.0.0-ALPHA-31")
    ],
    targets: [
        .binaryTarget(
            name: "Shared",
            path: "shared.xcframework.zip"
        ),
        .target(name: "Dependencies", dependencies: [
            .product(name: "KMPNativeCoroutinesCore", package: "KMP-NativeCoroutines"),
            .product(name: "KMPNativeCoroutinesAsync", package: "KMP-NativeCoroutines"),
        ])
    ]
)
