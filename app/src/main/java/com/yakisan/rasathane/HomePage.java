package com.yakisan.rasathane;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yakisan.rasathane.adapter.PostsAdapter;
import com.yakisan.rasathane.databinding.ActivityHomepageBinding;
import com.yakisan.rasathane.model.Posts;
import com.yakisan.rasathane.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePage extends AppCompatActivity {
    LinearLayoutManager llm;
    PostsAdapter adapter;
    List<Posts> postListesi = new ArrayList<>();

    //View Binding
    ActivityHomepageBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomepageBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);


        //RV init
        llm = new LinearLayoutManager(this);
        binding.rvPosts.setLayoutManager(llm);
        adapter = new PostsAdapter(postListesi);
        binding.rvPosts.setAdapter(adapter);

        postlariGetir();

     }
    //eof onCreate

    private void postlariGetir(){
        binding.progressBar.setVisibility(View.VISIBLE);
        RetrofitClient.getRetrofitClient().getPosts().enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                if(response.isSuccessful() && response.body() !=null){
                    binding.progressBar.setVisibility(View.GONE);
                    postListesi.addAll(response.body());
                    adapter.notifyDataSetChanged();
                    Log.e("deprem listesi", postListesi.toString());
                }else{
                    Log.e("empty_body", "Body Boş geliyor.");
                }
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                Toast.makeText(HomePage.this, "Hatalı", Toast.LENGTH_SHORT).show();
            }
        });
    }


}