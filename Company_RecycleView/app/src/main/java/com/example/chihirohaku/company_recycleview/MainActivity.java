package com.example.chihirohaku.company_recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.chihirohaku.company_recycleview.adapters.CompanyAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_company)
    RecyclerView rvCompany;
    private CompanyAdapter companyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setupUI();
    }

    private void setupUI() {
        companyAdapter = new CompanyAdapter();
        rvCompany.setLayoutManager(new GridLayoutManager(this, 2));
        rvCompany.setAdapter(companyAdapter);
    }
}
