package com.luunt.getlistfootinfo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.luunt.getlistfootinfo.MainActivity;
import com.luunt.getlistfootinfo.R;
import com.luunt.getlistfootinfo.models.FoodInfo;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Chihirohaku on 11/24/2016.
 */
public class FoodAdapter extends ArrayAdapter<FoodInfo> {

    public FoodAdapter(Context context, int resource, List<FoodInfo> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_list_food, parent, false);
        }
        FoodInfo foodInfo = getItem(position);

        ImageView imgFood = (ImageView) convertView.findViewById(R.id.img_food);
        TextView tvName = (TextView) convertView.findViewById(R.id.tv_name);
        TextView tvDetail = (TextView) convertView.findViewById(R.id.tv_detail);
        TextView tvPrice = (TextView) convertView.findViewById(R.id.tv_price);

        Picasso.with(this.getContext()).
                load(foodInfo.getImage())
                .into(imgFood);
        tvName.setText(foodInfo.getName());
        tvDetail.setText(foodInfo.getDetail());
        tvPrice.setText(String.format("%s VNĐ", foodInfo.getPrice()));

        return convertView;
    }
}
