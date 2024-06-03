// swift-tools-version:5.3
import PackageDescription

let package = Package(
   name: "Shared",
   platforms: [
     .iOS(.v14),
   ],
   products: [
      .library(name: "Shared", targets: ["shared"])
   ],
   targets: [
      .binaryTarget(
         name: "Shared",
         path: "./shared.xcframework.zip"
         )
   ]
)
