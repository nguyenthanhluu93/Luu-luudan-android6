package com.example.chihirohaku.musicapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chihirohaku.musicapp.R;
import com.example.chihirohaku.musicapp.eventbus.OpenFragmentEvent;
import com.example.chihirohaku.musicapp.fragments.TopSongFragment;
import com.example.chihirohaku.musicapp.models.Subgenres;
import com.example.chihirohaku.musicapp.models.SubgenresRealm;
import com.example.chihirohaku.musicapp.services.RealmContext;
import com.example.chihirohaku.musicapp.viewholders.MusicViewHolder;

import org.greenrobot.eventbus.EventBus;

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
    public void onBindViewHolder(MusicViewHolder holder, final int position) {
        holder.binView(RealmContext.getInstance().allSubgenres().get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TopSongFragment topSongFragment = new TopSongFragment();
                topSongFragment.setSubgenres(RealmContext.getInstance().allSubgenres().get(position));
                OpenFragmentEvent openFragmentEvent = new OpenFragmentEvent(topSongFragment, true, false);
                EventBus.getDefault().post(openFragmentEvent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return RealmContext.getInstance().allSubgenres().size();
    }
}
