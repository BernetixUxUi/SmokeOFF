package com.example.smokeoff.util;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.time.LocalDate;

public class DateManager {
    public static void saveStartDate(Context context, LocalDate start) {
        Gson gson = new Gson();
        String json = gson.toJson(start);

        SharedPreferencesManager.saveString(context, "DATA", "start", json);
    }

    public static LocalDate getStartDate(Context context) {
        String json = SharedPreferencesManager.getString(context, "DATA", "start", "");

        Gson gson = new Gson();
        Type type = new TypeToken<LocalDate>() {}.getType();
        LocalDate date = gson.fromJson(json, type);

        if (date == null) {
            date = LocalDate.now();
        }

        return date;
    }
}
