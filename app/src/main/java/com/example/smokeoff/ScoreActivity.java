 package com.example.smokeoff;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.smokeoff.util.SharedPreferencesManager;

 public class ScoreActivity extends AppCompatActivity {
    private TextView reasonTV, daysTV, hoursTV, dateTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_score);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getSupportActionBar().hide();

        daysTV = findViewById(R.id.textViewDays);
        hoursTV = findViewById(R.id.textViewHours);
        dateTV = findViewById(R.id.textViewDate);
        reasonTV = findViewById(R.id.textView18);

        findViewById(R.id.buttonBack).setOnClickListener(v-> finish());

        setRecordData();
    }

    private void setRecordData() {
        String record = SharedPreferencesManager.getString(this, "DATA", "record", " - - ");
        String reason = SharedPreferencesManager.getString(this, "DATA", "reason", "");
        String[] recordData = record.split("-");
        daysTV.setText(recordData[0]);
        hoursTV.setText(recordData[1]);
        dateTV.setText(recordData[2]);
        reasonTV.setText(reason);
    }
}