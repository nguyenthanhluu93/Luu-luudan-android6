package com.example.chihirohaku.oc.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chihirohaku.oc.MainActivity;
import com.example.chihirohaku.oc.R;
import com.example.chihirohaku.oc.models.Company;
import com.example.chihirohaku.oc.viewholders.CompanyViewHolder;

/**
 * Created by Chihirohaku on 12/18/2016.
 */

public class CompanyAdapter extends RecyclerView.Adapter<CompanyViewHolder> {
    @Override
    public CompanyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item_company, parent, false);
        CompanyViewHolder companyViewHolder = new CompanyViewHolder(view);
        return companyViewHolder;
    }

    @Override
    public void onBindViewHolder(CompanyViewHolder holder, int position) {
        Company company = Company.COMPANIES.get(position);
        holder.bind(company);
    }

    @Override
    public int getItemCount() {
        return Company.COMPANIES.size();
    }
}
