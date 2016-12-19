package com.example.chihirohaku.oc;

import com.example.chihirohaku.oc.models.CompanyBoby;

import java.util.List;

import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by Chihirohaku on 12/18/2016.
 */

public class DBContext {

    public static final Retrofit COMPANY_RETROFIT = new Retrofit.Builder()
            .baseUrl("https://a-server.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static Call<CompanyBoby> getCompanyResponse() {
        return COMPANY_RETROFIT.create(CompanyServices.class).companyBody();
    }
}
