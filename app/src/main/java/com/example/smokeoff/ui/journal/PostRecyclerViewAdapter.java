package com.example.smokeoff.ui.journal;

import android.content.Context;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.smokeoff.R;
import com.example.smokeoff.model.Post;
import java.util.ArrayList;

public class PostRecyclerViewAdapter extends RecyclerView.Adapter<PostRecyclerViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<Post> postArrayList;

    public PostRecyclerViewAdapter(Context context, ArrayList<Post> postArrayList) {
        this.context = context;
        this.postArrayList = postArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);//
        return new PostRecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.titleTV.setText(postArrayList.get(position).getNoSmokingDay());
        holder.contentTV.setText(postArrayList.get(position).getNote());
        holder.dateTV.setText(postArrayList.get(position).getDate().toString());
    }

    @Override
    public int getItemCount() {
        return postArrayList.size();
    }

//    public ArrayList<Post> getLatestRecipes() {
//        String userId = SharedPreferencesManager.getString(
//                context, SharedPreferencesName.AUTH, SharedPreferencesAuthKeys.USER_ID, ""
//        );
//
//        postArrayList.addAll(ApiMethods.getPostsByUserId(userId));
//        notifyDataSetChanged();
//
//        return postArrayList;
//    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView titleTV, contentTV, dateTV;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTV = itemView.findViewById(R.id.titleTV);
            contentTV = itemView.findViewById(R.id.contentTV);
            dateTV = itemView.findViewById(R.id.dateTV);
        }
    }
}