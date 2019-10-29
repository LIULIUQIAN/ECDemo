package com.example.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.latte.ec.icon.FontEcModule;
import com.example.lattecore.activities.ProxyActivity;
import com.example.lattecore.app.ConfigKeys;
import com.example.lattecore.app.Latte;
import com.example.lattecore.delegates.LatteDelegate;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

public class MainActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new ExampleFragment();
    }
}
