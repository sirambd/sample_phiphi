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
            url: "https://github.com/sirambd/sample_phiphi/releases/download/1.0.23/shared.xcframework.zip",
            checksum: "48508c575029d4a8c4d9c13bb2c93e3226ec5d5c680e213e95f37b6d8bd79ef6"
        )
    ]
)
