package com.example.chihirohaku.lab_6.services;

import com.example.chihirohaku.lab_6.models.BodyResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Chihirohaku on 12/18/2016.
 */

public interface LoginServices {
    @POST("login")
    Call<BodyResponse> login(@Body RequestBody body);
}
