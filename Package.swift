// swift-tools-version:5.10
import PackageDescription

let package = Package(
    name: "Shared",
    platforms: [
        .iOS(.v14),
        .macOS(.v11)
    ],
    products: [
        .library(name: "Shared", targets: ["Shared"])
    ],
    targets: [
        .binaryTarget(
            name: "Shared",
            path: "shared.xcframework.zip"
        )
    ]
)
