 package com.example.smokeoff;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuotActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quot);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getSupportActionBar().hide();

        String[] cytaty = {"Rzucenie palenia to najlepszy prezent, jaki możesz podarować sobie i swoim bliskim.",
                            "Nigdy nie jest za późno, aby rzucić palenie. Zacznij od jednego kroku.",
                            "Każdy papieros to krok w kierunku śmierci. Każdy dzień bez palenia to krok w kierunku życia.",
                            "Twoje płuca i serce będą Ci wdzięczne za rzucenie palenia.",
                            "Rzucenie palenia to nie łatwe zadanie, ale jest to możliwe. Jesteś silniejszy niż myślisz."};

        findViewById(R.id.buttonQuot1).setOnClickListener(v->{
            Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.layout_quote_first);

            TextView quot = dialog.findViewById(R.id.textViewQuot);
            quot.setText(cytaty[0]);
            dialog.findViewById(R.id.buttonBackQuot).setOnClickListener(dv->{
                dialog.dismiss();
            });
            dialog.show();
        });

        findViewById(R.id.buttonQuot2).setOnClickListener(v->{
            Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.layout_quote_first);

            TextView quot = dialog.findViewById(R.id.textViewQuot);
            quot.setText(cytaty[1]);
            dialog.findViewById(R.id.buttonBackQuot).setOnClickListener(dv->{
                dialog.dismiss();
            });
            dialog.show();
        });

        findViewById(R.id.buttonQuot3).setOnClickListener(v->{
            Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.layout_quote_first);

            TextView quot = dialog.findViewById(R.id.textViewQuot);
            quot.setText(cytaty[2]);
            dialog.findViewById(R.id.buttonBackQuot).setOnClickListener(dv->{
                dialog.dismiss();
            });
            dialog.show();
        });

        findViewById(R.id.buttonQuot4).setOnClickListener(v->{
            Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.layout_quote_first);

            TextView quot = dialog.findViewById(R.id.textViewQuot);
            quot.setText(cytaty[3]);
            dialog.findViewById(R.id.buttonBackQuot).setOnClickListener(dv->{
                dialog.dismiss();
            });
            dialog.show();
        });

        findViewById(R.id.buttonQuot5).setOnClickListener(v->{
            Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.layout_quote_first);

            TextView quot = dialog.findViewById(R.id.textViewQuot);
            quot.setText(cytaty[4]);
            dialog.findViewById(R.id.buttonBackQuot).setOnClickListener(dv->{
                dialog.dismiss();
            });
            dialog.show();
        });

        findViewById(R.id.buttonBack).setOnClickListener(v -> finish());
    }
}