package com.example.chihirohaku.lab5.services;

import com.example.chihirohaku.lab5.models.ResponData;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Chihirohaku on 12/6/2016.
 */

public interface RegisterService {
    @POST("home")
    Call<ResponData> register(@Body RequestBody body);
}
