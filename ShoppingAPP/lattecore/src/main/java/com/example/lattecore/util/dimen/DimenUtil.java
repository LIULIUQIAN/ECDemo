package com.example.lattecore.util.dimen;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.example.lattecore.app.Latte;

public class DimenUtil {
    public static int getScreenWidth(){
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight(){
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
