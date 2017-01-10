package com.example.chihirohaku.musicapp.viewholders;

import android.content.Context;
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
    Context context;

    public MusicViewHolder(Context context, View itemView) {
        super(itemView);
        this.context = context;
        imgTypeMusic = (ImageView) itemView.findViewById(R.id.img_music);
        tvNameMusic = (TextView) itemView.findViewById(R.id.tv_name_music);
    }

    public void binView(Subgenres subgenres) {
//            Drawable drawable = getgetResources().getDrawable(getResources()
//                    .getIdentifier("genre_" + subgenres.getId_img(), "drawable", getPackageName()));
//        imgTypeMusic.setBackgroundDrawable(drawable);

        String name = "genre_" + subgenres.getId_img();
        int id  = context.getResources().getIdentifier( name, "drawable", context.getPackageName());
        imgTypeMusic.setImageDrawable(context.getDrawable(id));

        tvNameMusic.setText(subgenres.getTranslationKey());
    }
}
