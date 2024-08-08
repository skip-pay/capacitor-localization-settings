// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "SkippayCapacitorLocalizationSettings",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "SkippayCapacitorLocalizationSettings",
            targets: ["LocalizationSettingsPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "LocalizationSettingsPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/LocalizationSettingsPlugin"),
        .testTarget(
            name: "LocalizationSettingsPluginTests",
            dependencies: ["LocalizationSettingsPlugin"],
            path: "ios/Tests/LocalizationSettingsPluginTests")
    ]
)