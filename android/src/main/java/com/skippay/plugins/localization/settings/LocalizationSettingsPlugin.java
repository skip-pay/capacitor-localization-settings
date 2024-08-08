package com.skippay.plugins.localization.settings;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "LocalizationSettings")
public class LocalizationSettingsPlugin extends Plugin {

    private final LocalizationSettings implementation = new LocalizationSettings();

    @PluginMethod
    public void getLanguage(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("value", implementation.getLanguage());
        call.resolve(ret);
    }

    @PluginMethod
    public void setLanguage(PluginCall call) {
        String value = call.getString("value");
        implementation.setLanguage(value);
        call.resolve();
    }
}
