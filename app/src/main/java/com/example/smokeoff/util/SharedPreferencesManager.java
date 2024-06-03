package com.example.smokeoff.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesManager {
    private static SharedPreferences getSharedPreferences(Context context, String preferencesName) {
        return context.getSharedPreferences(preferencesName, Context.MODE_PRIVATE);
    }

    public static void saveString(Context context, String preferencesName, String key, String value) {
        SharedPreferences.Editor editor = getSharedPreferences(context, preferencesName).edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getString(Context context, String preferencesName , String key, String defaultValue) {
        return getSharedPreferences(context, preferencesName).getString(key, defaultValue);
    }

    public static void saveBoolean(Context context, String preferencesName , String key, boolean value) {
        SharedPreferences.Editor editor = getSharedPreferences(context, preferencesName).edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static boolean getBoolean(Context context, String preferencesName , String key, boolean defaultValue) {
        return getSharedPreferences(context, preferencesName).getBoolean(key, defaultValue);
    }

    public static void clear(Context context, String preferencesName) {
        SharedPreferences.Editor editor = getSharedPreferences(context, preferencesName).edit();
        editor.clear();
        editor.apply();
    }

    public static void remove(Context context, String preferencesName , String key) {
        SharedPreferences.Editor editor = getSharedPreferences(context, preferencesName).edit();
        editor.remove(key);
        editor.apply();
    }

}


