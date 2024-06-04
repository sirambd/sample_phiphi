// swift-tools-version:5.3
import PackageDescription

let package = Package(
   name: "Shared",
   platforms: [
     .iOS(.v14),
   ],
   products: [
      .library(name: "Shared", targets: ["Shared"])
   ],
   targets: [
      .binaryTarget(
         name: "Shared",
         path: "shared.xcframework",
         dependencies: [
            // Swift Concurrency implementation
            .product(name: "KMPNativeCoroutinesAsync", package: "KMP-NativeCoroutines"),
         ]
         )
   ]
)
