package com.example.chihirohaku.retrofit.networks.aserver.services;

import com.example.chihirohaku.retrofit.networks.aserver.jsonmodels.RegisterRequestBody;
import com.example.chihirohaku.retrofit.networks.aserver.jsonmodels.RegisterResponseBody;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Chihirohaku on 12/6/2016.
 */

public interface RegisterService {
    @POST("register")
    Call<RegisterResponseBody> register(@Body RequestBody body);
}
