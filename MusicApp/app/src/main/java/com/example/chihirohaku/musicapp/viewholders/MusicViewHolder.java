package com.example.chihirohaku.musicapp.viewholders;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chihirohaku.musicapp.R;
import com.example.chihirohaku.musicapp.models.SubgenresRealm;
import com.squareup.picasso.Picasso;

/**
 * Created by Chihirohaku on 1/10/2017.
 */
public class MusicViewHolder extends RecyclerView.ViewHolder {

    ImageView imgTypeMusic;
    TextView tvNameMusic;

    public MusicViewHolder(View itemView) {
        super(itemView);
        imgTypeMusic = (ImageView) itemView.findViewById(R.id.img_music);
        tvNameMusic = (TextView) itemView.findViewById(R.id.tv_name_music);
    }

    public void binView(SubgenresRealm subgenresRealm) {

        String name = "genre_" + subgenresRealm.getId();
        int id  = this.itemView.getContext().getResources().getIdentifier( name, "drawable", this.itemView.getContext().getPackageName());
        Log.d("luunt1111111111", String.format("name: %s", id));
        Picasso.with(itemView.getContext()).load(id).into(imgTypeMusic);

        tvNameMusic.setText(subgenresRealm.getNameSubgenres());
    }
}
