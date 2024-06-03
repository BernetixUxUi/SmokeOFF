package com.example.smokeoff.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.smokeoff.MotivateActivity;
import com.example.smokeoff.SettingActivity;
import com.example.smokeoff.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.buttonSettings.setOnClickListener(v -> {goSettings();});
        binding.buttonMotivation.setOnClickListener(v -> {goMotivation();});
        binding.buttonReset.setOnClickListener(v -> System.out.println("reset"));
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void goSettings() {
        Intent intent = new Intent(getContext(), SettingActivity.class);
        startActivity(intent);
    }
    public void goMotivation() {
        Intent intent = new Intent(getContext(), MotivateActivity.class);
        startActivity(intent);
    }
}