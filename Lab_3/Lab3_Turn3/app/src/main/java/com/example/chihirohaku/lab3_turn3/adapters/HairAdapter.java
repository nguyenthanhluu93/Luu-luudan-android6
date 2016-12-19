package com.example.chihirohaku.lab3_turn3.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chihirohaku.lab3_turn3.R;
import com.example.chihirohaku.lab3_turn3.models.MHair;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Chihirohaku on 11/24/2016.
 */
public class HairAdapter extends ArrayAdapter<MHair> {

    public HairAdapter(Context context, int resource, MHair[] objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_list_hair, parent, false);
        }
        MHair mHair = getItem(position);

        ImageView imgHair = (ImageView) convertView.findViewById(R.id.img_hair);
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
        TextView tvDetail = (TextView) convertView.findViewById(R.id.tv_detail);

//        Picasso.with(this.getContext()).
//                load(mHair.getHairs().get(0).)
//                .into(imgHair);
//        tvTitle.setText();
//        tvDetail.setText(foodInfo.getDetail());
//        tvPrice.setText(String.format("%s VNĐ", foodInfo.getPrice()));

        return convertView;
    }
}
