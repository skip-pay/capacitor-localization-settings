import Foundation

@objc public class LocalizationSettings: NSObject {
    @objc public func getLanguage() {
        let language = Locale.preferredLanguages[0]
        return language
    }
    @objc public func setLanguage(_ value: String) {
        let locale = Locale(identifier: value)
        UserDefaults.standard.set([value], forKey: "AppleLanguages")
        UserDefaults.standard.synchronize()
        return value
    }
}
