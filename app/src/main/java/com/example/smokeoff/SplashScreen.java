package com.example.smokeoff;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.smokeoff.util.DateManager;
import com.example.smokeoff.util.SharedPreferencesManager;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);

        final String userID = SharedPreferencesManager.getString(this, "DATA", "id", "1");
        if (userID.isEmpty()) {
            SharedPreferencesManager.saveString(this, "DATA", "id", generateID());
            System.out.println("Nowy klucz");
            SharedPreferencesManager.saveString(this, "DATA", "noSmokingDays", "0");
            DateManager.saveStartDate(this, LocalDate.now());
        }

        long days = ChronoUnit.DAYS.between(DateManager.getStartDate(this), LocalDate.now());
        SharedPreferencesManager.saveString(this, "DATA", "noSmokingDays", ""+days);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 3000);

            return insets;
        });
        getSupportActionBar().hide();

    }

    private String generateID() {
        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        final int LENGTH = 30;
        final SecureRandom RANDOM = new SecureRandom();

        StringBuilder sb = new StringBuilder(LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            int index = RANDOM.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        return sb.toString();
    }
}