package com.example.shoppingapp.application;

import android.app.Application;

import com.example.lattecore.app.Latte;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

public class ECApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initLatte();
    }

    private void initLatte(){
        Latte.init(this)
                .withApiHost("http://www.baidu.com")
                .configure();
    }
}
