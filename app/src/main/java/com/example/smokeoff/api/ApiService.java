package com.example.smokeoff.api;

import com.example.smokeoff.model.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.*;

public interface ApiService {
    @GET("posts/{userId}/all")
    Call<ArrayList<Post>> getAllPosts(@Path("userId") String userId);
    @POST("posts")
    Call<Post> createPost(@Body Post post);
}