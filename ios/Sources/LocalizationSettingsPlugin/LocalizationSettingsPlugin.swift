import Foundation
import Capacitor

@objc(LocalizationSettingsPlugin)
public class LocalizationSettingsPlugin: CAPPlugin, CAPBridgedPlugin {
    public let identifier = "LocalizationSettingsPlugin"
    public let jsName = "LocalizationSettings"
    public let pluginMethods: [CAPPluginMethod] = [
        CAPPluginMethod(name: "getLanguage", returnType: CAPPluginReturnPromise)
        CAPPluginMethod(name: "setLanguage", returnType: CAPPluginReturnPromise)
    ]
    private let implementation = LocalizationSettings()

    @objc func getLanguage(_ call: CAPPluginCall) {
        let value = implementation.getLanguage()
        call.resolve([
            "value": value
        ])
    }
    @objc func setLanguage(_ call: CAPPluginCall) {
        let value = call.getString("value") ?? ""
        let result = implementation.setLanguage(value)

        call.resolve([
            "value": result
        ])
    }
}
