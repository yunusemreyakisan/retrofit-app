package com.yakisan.retrofit.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yakisan.rasathane.R;
import com.yakisan.retrofit.model.Posts;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    List<Posts> postListesi;


    public PostsAdapter(List<Posts> postListesi) {
        this.postListesi = postListesi;
    }

    @NonNull
    @Override
    public PostsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsAdapter.ViewHolder holder, int position) {
        holder.tvTitle.setText(postListesi.get(position).getTitle());
        holder.tvBody.setText(postListesi.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return postListesi.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle, tvBody;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvBody = itemView.findViewById(R.id.tvBody);
        }
    }


}
