package com.example.chihirohaku.musicapp.services;

import com.example.chihirohaku.musicapp.models.ResponseMusic;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Chihirohaku on 1/10/2017.
 */

public interface GetAllMusicServices {
    @GET("media-types.json")
    Call<List<ResponseMusic>> getAllMusic();
}
