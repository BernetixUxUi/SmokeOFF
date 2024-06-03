 package com.example.smokeoff;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MotivateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_motivate);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getSupportActionBar().hide();
    }
    public void goBack(View view) {
        finish();
    }


    public void goQuote(View view) {
        Intent intent = new Intent(this, QuotActivity.class);
        startActivity(intent);
    }
    public void goScore(View view) {
        Intent intent = new Intent(this, ScoreActivity.class);
        startActivity(intent);
    }
}