package com.example.chihirohaku.musicapp.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chihirohaku.musicapp.R;
import com.example.chihirohaku.musicapp.butterknife.OpenFragmentEvent;
import com.example.chihirohaku.musicapp.fragments.TopSongFragment;
import com.example.chihirohaku.musicapp.models.Subgenres;
import com.example.chihirohaku.musicapp.viewholders.MusicViewHolder;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Chihirohaku on 1/10/2017.
 */

public class MusicAdapter extends RecyclerView.Adapter<MusicViewHolder> {

    Activity context;
    @Override
    public MusicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_music, parent, false);
        MusicViewHolder musicViewHolder = new MusicViewHolder(parent.getContext(), view);
        return musicViewHolder;
    }

    @Override
    public void onBindViewHolder(MusicViewHolder holder, int position) {
        holder.binView(Subgenres.getSubgenresList().get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenFragmentEvent openFragmentEvent = new OpenFragmentEvent(new TopSongFragment(), true);
                EventBus.getDefault().post(openFragmentEvent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Subgenres.getSubgenresList().size();
    }
}
