package com.example.chihirohaku.oc.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chihirohaku.oc.R;
import com.example.chihirohaku.oc.models.Company;
import com.example.chihirohaku.oc.models.Image;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Chihirohaku on 12/18/2016.
 */
public class CompanyViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.img_logo)
    ImageView imgLogo;
    @BindView(R.id.tv_name)
    TextView tvName;

    public CompanyViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        imgLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
    }

    public void bind(Company company) {
        Picasso.with(itemView.getContext()).load(company.getImageList().get(0).getUrlImage()).into(imgLogo);
        tvName.setText(company.getName());
    }
}
