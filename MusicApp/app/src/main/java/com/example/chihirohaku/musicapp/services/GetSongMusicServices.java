package com.example.chihirohaku.musicapp.services;

import com.example.chihirohaku.musicapp.models.ResponseSong;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Chihirohaku on 1/10/2017.
 */

public interface GetSongMusicServices {
    @GET("genre={id}/explicit=true/json")
    Call<ResponseSong> getAllSongByType(@Path("id") String id);
}
