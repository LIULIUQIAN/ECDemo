package com.example.lattecore.util.storage;


import android.content.SharedPreferences;

import com.example.lattecore.app.Latte;

import org.json.JSONObject;

public final class LattePreference {

    private static final String APP_PREFERENCES_KEY = "profile";
    public static String PREFERENCE_NAME = "Cniao_Pref_Common";
    private static final SharedPreferences PREFERENCES = Latte.getApplicationContext().getSharedPreferences(PREFERENCE_NAME,Latte.getApplicationContext().MODE_PRIVATE);

    private static SharedPreferences getAppPreference(){
        return PREFERENCES;
    }

    public static void setAppProfile(String val){
        getAppPreference().edit().putString(APP_PREFERENCES_KEY,val).apply();
    }

    public static String getAppProfile(){
       return getAppPreference().getString(APP_PREFERENCES_KEY,null);
    }

    public static void removeAppProfile(){
        getAppPreference().edit().remove(APP_PREFERENCES_KEY).apply();
    }

    public static void clearAppPreferences(){
        getAppPreference().edit().clear().apply();
    }

    public static void setAppFlag(String key, boolean flag){
        getAppPreference().edit().putBoolean(key,flag).apply();
    }

    public static boolean getAppFlag(String key){
       return getAppPreference().getBoolean(key,false);
    }

    public static void addCustomAppProfile(String key, String val){
         getAppPreference().edit().putString(key,val).apply();
    }

    public static String getCustomAppProfile(String key){
        return getAppPreference().getString(key,"");
    }


}
