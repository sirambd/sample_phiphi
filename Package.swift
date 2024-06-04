// swift-tools-version:5.10
import PackageDescription

let package = Package(
   name: "Shared",
   platforms: [
     .iOS(.v14),
   ],
   products: [
      .library(name: "Shared", targets: ["Shared"])
   ],
   dependencies: [
       .package(url: "https://github.com/rickclephas/KMP-NativeCoroutines.git", exact: "1.0.0-ALPHA-31")
   ],
   targets: [
      .target(
         name: "Shared",
         dependencies: [
            .product(name: "KMPNativeCoroutinesAsync", package: "KMP-NativeCoroutines"),
         ],
         path: "shared.xcframework"
      )
   ]
)
