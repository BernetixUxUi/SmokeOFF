package com.example.smokeoff.ui.calc;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.smokeoff.databinding.FragmentCalcBinding;

import java.util.Locale;

public class CalcFragment extends Fragment {

    private FragmentCalcBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CalcViewModel calcViewModel =
                new ViewModelProvider(this).get(CalcViewModel.class);

        binding = FragmentCalcBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        EditText priceEditText = binding.editTextPrice;
        EditText countEditText = binding.editTextCount;
        TextView resultTextView = binding.textViewResult;

        binding.buttonDoMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String priceString = priceEditText.getText().toString();
                String countString = countEditText.getText().toString();

                if (TextUtils.isEmpty(priceString) || TextUtils.isEmpty(countString)) {
                    return;
                }

                try {
                    double price = Double.parseDouble(priceString);
                    int count = Integer.parseInt(countString);

                    double costPerDay = price * count;

                    resultTextView.setText(String.format("%.2f zł", costPerDay));
                } catch (NumberFormatException e) {
                    return;
                }
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
