package com.example.chihirohaku.musicapp.services;

import com.example.chihirohaku.musicapp.models.ResponseDataSong;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Chihirohaku on 2/7/2017.
 */

public interface GetDataSongServices {
    @GET("song?")
    Call<ResponseDataSong> getTopMusic(@Query("requestdata") String requestdata);
}
