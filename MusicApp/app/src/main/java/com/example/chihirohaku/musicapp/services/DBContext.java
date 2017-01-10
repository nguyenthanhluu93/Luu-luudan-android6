package com.example.chihirohaku.musicapp.services;

import com.example.chihirohaku.musicapp.models.ResponseMusic;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Chihirohaku on 1/10/2017.
 */

public class DBContext {
    public static final Retrofit GETMUSIC_RETROFIT = new Retrofit.Builder()
            .baseUrl("https://rss.itunes.apple.com/data/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static Call<List<ResponseMusic>> getMusicsRepos() {
        return GETMUSIC_RETROFIT.create(GetAllMusicServices.class).getAllMusic();
    }
}
