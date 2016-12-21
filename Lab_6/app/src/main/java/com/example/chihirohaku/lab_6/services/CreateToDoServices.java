package com.example.chihirohaku.lab_6.services;

import com.example.chihirohaku.lab_6.models.Note;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Chihirohaku on 12/20/2016.
 */

public interface CreateToDoServices {
    @POST("todos")
    Call<List<Note>> createNote(@Body RequestBody body, @Header("token") String token);
}
