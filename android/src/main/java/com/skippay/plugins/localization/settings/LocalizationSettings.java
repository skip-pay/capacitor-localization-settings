package com.skippay.plugins.localization.settings;

import android.os.Build;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.os.LocaleListCompat;

import java.util.Locale;

public class LocalizationSettings {
    public String getLanguage() {
        return getCurrentLanguage();
    }

    public void setLanguage(String value) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            LocaleListCompat localeList = LocaleListCompat.forLanguageTags(getLanguageTag(value));
            AppCompatDelegate.setApplicationLocales(localeList);
        }
    }

    private String getLanguageTag(String language) {
        Locale locale = Locale.forLanguageTag(language);


        if (!locale.getCountry().isEmpty()) {
            return locale.toLanguageTag();
        }

        return new Locale(locale.getLanguage(), Locale.getDefault().getCountry()).toLanguageTag();
    }

    private String getCurrentLanguage() {
        // If API version is >= 33, then use per-app language settings
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            String currentLocaleName;
            if (!AppCompatDelegate.getApplicationLocales().isEmpty()) {
                // get per-app language
                Locale locale = AppCompatDelegate.getApplicationLocales().get(0);
                currentLocaleName = (locale != null) ? locale.toLanguageTag() : null;
            } else {
                // Fallback to the default System Locale
                currentLocaleName = Locale.getDefault().toLanguageTag();
            }
            return currentLocaleName;
        } else {
            return Locale.getDefault().toLanguageTag();
        }
    }

}
