package com.example.chihirohaku.musicapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.example.chihirohaku.musicapp.R;
import com.example.chihirohaku.musicapp.eventbus.ShowMiniEvent;
import com.example.chihirohaku.musicapp.models.Entry;
import com.example.chihirohaku.musicapp.models.SongRealm;
import com.example.chihirohaku.musicapp.models.SubgenresRealm;
import com.example.chihirohaku.musicapp.services.RealmContext;
import com.example.chihirohaku.musicapp.viewholders.SongViewHolder;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chihirohaku on 1/12/2017.
 */

public class SongAdapter extends RecyclerView.Adapter<SongViewHolder> {

    private SubgenresRealm subgenresRealm;

    public void setSubgenresRealm(SubgenresRealm subgenresRealm) {
        this.subgenresRealm = subgenresRealm;
    }

    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_song, parent, false);
        SongViewHolder songViewHolder = new SongViewHolder(view);
        return songViewHolder;
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, final int position) {
        holder.binView(subgenresRealm.getSongRealmList().get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowMiniEvent showMiniFragment = new ShowMiniEvent(true, subgenresRealm.getSongRealmList().get(position));
                EventBus.getDefault().post(showMiniFragment);
            }
        });
    }

    @Override
    public int getItemCount() {
        return subgenresRealm.getSongRealmList().size();
    }

}
