package com.example.smokeoff.api;

import com.example.smokeoff.model.Post;
import com.example.smokeoff.ui.journal.PostRecyclerViewAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ApiMethods {
    private static final Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("http://192.168.56.1:8080/api/")
            .addConverterFactory(GsonConverterFactory.create());

    private static final Retrofit retrofit = builder.build();

    private static final ApiService api = retrofit.create(ApiService.class);

    public static ArrayList<Post> getPostsByUserId(String id, PostRecyclerViewAdapter adapter) {
        ArrayList<Post> result = new ArrayList<>();
        Call<ArrayList<Post>> call = api.getAllPosts(id);

        call.enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                if (response.isSuccessful()) {
                    result.addAll(response.body());
                    adapter.clearData();
                    adapter.addPosts(result);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {
                //Jakieś info z Toastem
                System.out.println(t.getMessage());
            }
        });

        return result;
    }

    public static Post createPost(Post post, PostRecyclerViewAdapter adapter) {
        Call<Post> call = api.createPost(post);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Post responseResult = response.body();
                    post.setId(response.body().getId());
                    ArrayList<Post> res = new ArrayList<>();
                    res.add(post);
                    adapter.addPosts(res);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
            }
        });

        return post;
    }
}