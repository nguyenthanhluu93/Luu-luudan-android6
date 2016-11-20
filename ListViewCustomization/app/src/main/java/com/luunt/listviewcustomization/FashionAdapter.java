package com.luunt.listviewcustomization;

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
public class FashionAdapter extends ArrayAdapter<FashionItem> {

    public FashionAdapter(Context context, int resource, List<FashionItem> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1: cang view
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.listview_item_fashion, parent, false);
        }

        // 2: lay data
        FashionItem fashionItem = getItem(position);

        // 3: do data vao view
//        TextView tvTitle = (TextView) convertView.findViewById(R.id.tv_fashion_title);
//        ImageView imgFashionItem = (ImageView) convertView.findViewById(R.id.img_fashion_item);

        new FashionViewHolder(convertView).setData(fashionItem);

        // 4:
//        tvTitle.setText(fashionItem.getTitle());
//        imgFashionItem.setImageResource(fashionItem.getImResId());


        return convertView;

    }
}
