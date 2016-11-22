package com.luunt.lab2_turn4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Chihirohaku on 11/20/2016.
 */
public class FavoriteAdapter extends ArrayAdapter<FavoriteItem> {

    public FavoriteAdapter(Context context, int resource, List<FavoriteItem> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_list_favorite, parent, false);
        }

        FavoriteItem favoriteItem = getItem(position);
        TextView tvContent = (TextView) convertView.findViewById(R.id.tv_content);
        TextView tvTime = (TextView) convertView.findViewById(R.id.tv_time);
        ImageView imgFavorite = (ImageView) convertView.findViewById(R.id.img_favorite);

        tvContent.setText(favoriteItem.getContent());
        tvTime.setText(favoriteItem.getTime());
        imgFavorite.setImageResource(favoriteItem.getImgFavorite());

        return convertView;

    }
}
