package com.example.chihirohaku.oc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.chihirohaku.oc.adapters.CompanyAdapter;
import com.example.chihirohaku.oc.models.Company;
import com.example.chihirohaku.oc.models.CompanyBoby;


import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_company)
    RecyclerView rvCompany;
    private CompanyAdapter companyAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        sendGET();
        setupUI();
    }

    private void setupUI() {
        companyAdapter = new CompanyAdapter();
        final LinearLayoutManager ln = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvCompany.setLayoutManager(ln);
        rvCompany.setAdapter(companyAdapter);
    }

    private void sendGET() {
        DBContext.getCompanyResponse().enqueue(new Callback<CompanyBoby>() {
            @Override
            public void onResponse(Call<CompanyBoby> call, Response<CompanyBoby> response) {
                Company.COMPANIES = response.body().getContent().getCompanyList();
                for (Company company : Company.COMPANIES) {
                    Log.d("oc", company.toString());
                }
            }

            @Override
            public void onFailure(Call<CompanyBoby> call, Throwable t) {

            }
        });
    }
}
