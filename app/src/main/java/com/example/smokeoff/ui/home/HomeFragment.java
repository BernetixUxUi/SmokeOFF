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
import com.example.smokeoff.util.SharedPreferencesManager;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.buttonMotivation.setOnClickListener(v -> {goMotivation();});
        binding.buttonReset.setOnClickListener(v -> resetTimer(binding));

        setTimer(binding);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void goMotivation() {
        Intent intent = new Intent(getContext(), MotivateActivity.class);
        startActivity(intent);
    }

    private void setTimer(FragmentHomeBinding bindingArg) {
        String start = SharedPreferencesManager.getString(getContext(), "DATA", "start", "0");
        String now = LocalDateTime.now().format(formatter);

        LocalDateTime startDateTime = LocalDateTime.parse(start, formatter);
        LocalDateTime nowDateTime = LocalDateTime.parse(now, formatter);

        Duration duration = Duration.between(startDateTime, nowDateTime);

        long hours = duration.toHours();
        long days = hours / 24;
        hours = hours % 24;

        bindingArg.textViewDays.setText(""+days);
        bindingArg.textViewHours.setText(""+hours);

//        System.out.println(duration.toMinutes());
        System.out.println(start);
    }

    private void resetTimer(FragmentHomeBinding bindingArg) {
        String start = SharedPreferencesManager.getString(getContext(), "DATA", "start", "0");
        String now = LocalDateTime.now().format(formatter);

        LocalDateTime startDateTime = LocalDateTime.parse(start, formatter);
        LocalDateTime nowDateTime = LocalDateTime.parse(now, formatter);

        Duration duration = Duration.between(startDateTime, nowDateTime);

        long hours = duration.toHours();
        long days = hours / 24;
        hours = hours % 24;

        String record = SharedPreferencesManager.getString(getContext(), "DATA", "record", "0-0- ");
        String[] recordData = record.split("-");

        //Ustawianie nowego rekoru
        if (days > Integer.parseInt(recordData[0]) || (days == Integer.parseInt(recordData[0]) && hours > Integer.parseInt(recordData[1]))) {
            String date = now.substring(0,10).replace("-", ".");
            String newRecord = days+"-"+hours+"-"+date;
            SharedPreferencesManager.saveString(getContext(), "DATA", "record", newRecord);
            SharedPreferencesManager.saveString(getContext(), "DATA", "reason", "test");
            //TODO nowy powód zapalenia
        }

        SharedPreferencesManager.saveString(getContext(), "DATA", "start", now);
        setTimer(bindingArg);
    }
}