package com.example.chihirohaku.musicapp.viewholders;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chihirohaku.musicapp.R;
import com.example.chihirohaku.musicapp.models.Subgenres;

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

    public void binView(Subgenres subgenres) {
//            Drawable drawable = getgetResources().getDrawable(getResources()
//                    .getIdentifier("genre_" + subgenres.getId_img(), "drawable", getPackageName()));
//        imgTypeMusic.setBackgroundDrawable(drawable);
        tvNameMusic.setText(subgenres.getTranslationKey());
    }
}
