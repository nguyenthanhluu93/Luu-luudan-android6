package com.example.chihirohaku.oc;

import com.example.chihirohaku.oc.models.CompanyBoby;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Chihirohaku on 12/18/2016.
 */

public interface CompanyServices {
    @GET("company")
    Call<CompanyBoby> companyBody();
}
