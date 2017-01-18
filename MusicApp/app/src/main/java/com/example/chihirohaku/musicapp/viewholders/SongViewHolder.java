package com.example.chihirohaku.musicapp.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.chihirohaku.musicapp.R;
import com.example.chihirohaku.musicapp.models.Entry;
import com.example.chihirohaku.musicapp.models.SongRealm;
import com.example.chihirohaku.musicapp.models.SubgenresRealm;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Chihirohaku on 1/12/2017.
 */
public class SongViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.list_item_song_circle_image)
    CircleImageView imgSong;
    @BindView(R.id.list_item_song_name)
    TextView tvSong;
    @BindView(R.id.list_item_song_author)
    TextView tvAuthor;

    public SongViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void binView(SongRealm songRealm) {
        Picasso.with(this.itemView.getContext()).load(songRealm.getUrlImageSong()).into(imgSong);
        tvSong.setText(songRealm.getSongName());
        tvAuthor.setText(songRealm.getArtistName());
    }
}
