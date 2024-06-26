package com.example.smokeoff.ui.journal;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smokeoff.R;
import com.example.smokeoff.api.ApiMethods;
import com.example.smokeoff.databinding.FragmentJournalBinding;
import com.example.smokeoff.model.Post;
import com.example.smokeoff.util.SharedPreferencesManager;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class JournalFragment extends Fragment {

    private FragmentJournalBinding binding;
    private ArrayList<Post> posts = new ArrayList<>();
    private PostRecyclerViewAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        JournalViewModel notificationsViewModel = new ViewModelProvider(this).get(JournalViewModel.class);

        binding = FragmentJournalBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.buttonAdd.setOnClickListener(v -> {
            addPost();
        });

        RecyclerView recyclerView = binding.postRecyclerView;
        adapter = new PostRecyclerViewAdapter(getContext(), posts);


        posts = ApiMethods.getPostsByUserId(SharedPreferencesManager.getString(getContext(), "DATA", "id", "1"), adapter);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void getData() {
        final String id = SharedPreferencesManager.getString(getContext(), "DATA", "id", "1");

        ArrayList<Post> postArrayList = ApiMethods.getPostsByUserId(id, adapter);
        for (Post p : postArrayList) {
            System.out.println(p.getNote());
        }
        adapter.addPosts(postArrayList);
        adapter.notifyDataSetChanged();
    }

    private void addPost() {
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.layout_add_post);
        EditText contentET = dialog.findViewById(R.id.editTextTextMultiLine);

        dialog.findViewById(R.id.button2).setOnClickListener(v -> {
            final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

            if (contentET.getText().toString().trim().isEmpty()) {
                return;
            }
            final String id = SharedPreferencesManager.getString(getContext(), "DATA", "id", "1");
            String start = SharedPreferencesManager.getString(getContext(), "DATA", "start", "0");
            String now = LocalDateTime.now().format(formatter);

            LocalDateTime startDateTime = LocalDateTime.parse(start, formatter);
            LocalDateTime nowDateTime = LocalDateTime.parse(now, formatter);

            Duration duration = Duration.between(startDateTime, nowDateTime);

            long hours = duration.toHours();
            long days = hours / 24;
            LocalDate date = LocalDate.now();


            Post newPost = new Post();
            newPost.setId(null);
            newPost.setUserId(id);
            newPost.setNote(contentET.getText().toString());
            newPost.setDate(date.toString());
            newPost.setNoSmokingDay((int) days);


            synchronized (ApiMethods.createPost(newPost, adapter)) {
                posts.add(newPost);
                adapter.notifyDataSetChanged();
            }

            dialog.dismiss();
        });

        dialog.show();
    }
}