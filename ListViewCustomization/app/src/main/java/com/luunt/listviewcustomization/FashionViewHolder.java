package com.luunt.listviewcustomization;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Chihirohaku on 11/20/2016.
 */
public class FashionViewHolder {

//    @BindView(R.id.tv_fashion_title)
//    TextView tvTitle;
//
//    @BindView(R.id.img_fashion_item)
//    ImageView imgFashion;

    public TextView tvTitle;
    ImageView imgFashion;

    public FashionViewHolder(View rootView) {
//        ButterKnife.bind(this, rootView);
        tvTitle = (TextView) rootView.findViewById(R.id.tv_fashion_title);
        imgFashion = (ImageView) rootView.findViewById(R.id.img_fashion_item);
    }

    public void setData(FashionItem fashionItem) {
        tvTitle.setText(fashionItem.getTitle());
        imgFashion.setImageResource(fashionItem.getImResId());
    }
}
