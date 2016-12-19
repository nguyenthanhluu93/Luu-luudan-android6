package com.example.chihirohaku.company_recycleview.viewholders;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chihirohaku.company_recycleview.R;
import com.example.chihirohaku.company_recycleview.models.Company;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Chihirohaku on 12/13/2016.
 */
public class CompanyViewHolder extends RecyclerView.ViewHolder {

    private static final String TAG = CompanyViewHolder.class.toString();
    @BindView(R.id.iv_company)
    ImageView ivCompany;
    @BindView(R.id.tv_name)
    TextView tvName;

    public CompanyViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Company company) {
        Picasso.with(this.itemView.getContext()).load(company.getImageUrl()).into(ivCompany);
        tvName.setText(company.getName());
    }
}
