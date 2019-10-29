package com.example.shoppingapp;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View;

import com.example.lattecore.delegates.LatteDelegate;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExampleFragment extends LatteDelegate {


    @Override
    public Object setLayout() {
        return R.layout.fragment_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        System.out.println("aaaaaaa");
    }
}
