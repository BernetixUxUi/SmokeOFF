package com.example.smokeoff.ui.journal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smokeoff.api.ApiMethods;
import com.example.smokeoff.databinding.FragmentJournalBinding;
import com.example.smokeoff.model.Post;

import java.util.ArrayList;

public class JournalFragment extends Fragment {

    private FragmentJournalBinding binding;
    private ArrayList<Post> posts=new ArrayList<>();
    private PostRecyclerViewAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        JournalViewModel notificationsViewModel = new ViewModelProvider(this).get(JournalViewModel.class);

        binding = FragmentJournalBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        getData();

        binding.buttonAdd.setOnClickListener(v -> {
            getData();
        });

        RecyclerView recyclerView = binding.postRecyclerView;
        adapter = new PostRecyclerViewAdapter(getContext(), posts);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void getData(){
        posts.addAll(ApiMethods.getPostsByUserId("1"));
        adapter.notifyDataSetChanged();

    }
}