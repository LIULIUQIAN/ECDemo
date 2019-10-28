package com.example.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.lattecore.app.ConfigKeys;
import com.example.lattecore.app.Latte;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Latte.init(this)
                .withApiHost("http//:www.baidu.com")
        .configure();

        System.out.println("==========");
        System.out.println(Latte.getConfiguration(ConfigKeys.API_HOST));
    }
}
