package com.example.chihirohaku.musicapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chihirohaku.musicapp.R;
import com.example.chihirohaku.musicapp.viewholders.GenresLikedViewHolder;

/**
 * Created by User on 1/23/2017.
 */

public class GenresLikedAdapter extends RecyclerView.Adapter<GenresLikedViewHolder> {
    @Override
    public GenresLikedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_genres_liked, parent, false);
        GenresLikedViewHolder viewHolder = new GenresLikedViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(GenresLikedViewHolder holder, int position) {
//        holder.binView();
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
