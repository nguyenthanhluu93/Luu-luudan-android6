package com.example.chihirohaku.lab_6.services;

import com.example.chihirohaku.lab_6.models.Note;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by Chihirohaku on 12/20/2016.
 */

public interface AllListToDoServices {
    @GET("todos")
    Call<List<Note>> getAllNotes(@Header("token") String token);
}
