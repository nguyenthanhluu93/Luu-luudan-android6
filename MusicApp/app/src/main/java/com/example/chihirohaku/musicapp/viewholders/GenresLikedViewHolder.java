package com.example.chihirohaku.musicapp.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.chihirohaku.musicapp.R;
import com.example.chihirohaku.musicapp.models.SubgenresRealm;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by User on 1/23/2017.
 */
public class GenresLikedViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.list_item_genres_liked_tv_title)
    TextView tvTitle;

    public GenresLikedViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void binView(SubgenresRealm subgenresRealm) {
        if (subgenresRealm.isLike() == true) {
            tvTitle.setText(subgenresRealm.getNameSubgenres());
        }
    }
}
