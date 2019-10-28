package com.example.lattecore.app;

import android.content.Context;

public final class Latte {

    public static Configurator init(Context context) {
        getConfigurator()
                .getLatteConfigs()
                .put(ConfigKeys.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return getConfigurator();
    }

    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    public static <T> T getConfiguration(Enum<ConfigKeys> key) {
        return getConfigurator().getConfiguration(key);
    }
}
