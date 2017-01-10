package com.example.chihirohaku.musicapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chihirohaku.musicapp.R;
import com.example.chihirohaku.musicapp.models.Subgenres;
import com.example.chihirohaku.musicapp.viewholders.MusicViewHolder;

import java.util.zip.Inflater;

/**
 * Created by Chihirohaku on 1/10/2017.
 */

public class MusicAdapter extends RecyclerView.Adapter<MusicViewHolder> {
    @Override
    public MusicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_music, parent, false);
        MusicViewHolder musicViewHolder = new MusicViewHolder(view);
        return musicViewHolder;
    }

    @Override
    public void onBindViewHolder(MusicViewHolder holder, int position) {
        holder.binView(Subgenres.getSubgenresList().get(position));
    }

    @Override
    public int getItemCount() {
        return Subgenres.getSubgenresList().size();
    }
}
