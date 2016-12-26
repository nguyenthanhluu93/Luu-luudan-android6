package com.example.chihirohaku.lab_6.services;

import com.example.chihirohaku.lab_6.models.Note;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Chihirohaku on 12/25/2016.
 */

public interface EditToDoServices {
    @PUT("todos/{id}")
    Call<Note> editNote(@Body RequestBody body, @Header("token") String token, @Path("id") String id);
}
