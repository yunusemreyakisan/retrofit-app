package com.yakisan.retrofit.retrofit;

import com.yakisan.retrofit.model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IAPI {

    @GET("/posts")
    Call<List<Posts>> getPosts();



}
