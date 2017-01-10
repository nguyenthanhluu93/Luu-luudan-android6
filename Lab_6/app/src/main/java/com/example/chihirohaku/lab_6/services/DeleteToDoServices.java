package com.example.chihirohaku.lab_6.services;

import com.example.chihirohaku.lab_6.models.BodyResponse;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * Created by Chihirohaku on 12/27/2016.
 */

public interface DeleteToDoServices {
    @DELETE("todos/{id}")
    Call<BodyResponse> deleteNote(@Path("id") String id, @Header("token") String token);
}
