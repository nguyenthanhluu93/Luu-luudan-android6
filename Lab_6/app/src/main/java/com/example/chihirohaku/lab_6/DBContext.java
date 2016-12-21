package com.example.chihirohaku.lab_6;

import com.example.chihirohaku.lab_6.models.Account;
import com.example.chihirohaku.lab_6.models.BodyResponse;
import com.example.chihirohaku.lab_6.models.Note;
import com.example.chihirohaku.lab_6.services.AllListToDoServices;
import com.example.chihirohaku.lab_6.services.CreateToDoServices;
import com.example.chihirohaku.lab_6.services.LoginServices;
import com.example.chihirohaku.lab_6.services.RegisterServices;
import com.google.gson.Gson;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by Chihirohaku on 12/18/2016.
 */

public class DBContext {
    public static final Retrofit REGISTER_RETROFIT = new Retrofit.Builder()
            .baseUrl("http://a-server.herokuapp.com/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static Call<BodyResponse> getRegisterBody(Account account){
        RequestBody requestBody = RequestBody.create(
                MediaType.parse("application/json"),
                (new Gson()).toJson(account));
        return REGISTER_RETROFIT.create(RegisterServices.class).register(requestBody);
    }

    public static Call<BodyResponse> getLoginBody(Account account){
        RequestBody requestBody = RequestBody.create(
                MediaType.parse("application/json"),
                (new Gson()).toJson(account));
        return REGISTER_RETROFIT.create(LoginServices.class).login(requestBody);
    }

    public static Call<List<Note>> getNoteRepos(String token) {
        return REGISTER_RETROFIT.create(AllListToDoServices.class).getAllNotes(token);
    }

    public static Call<List<Note>> getNoteBody(Note note, String token){
        RequestBody requestBody = RequestBody.create(
                MediaType.parse("application/json"),
                (new Gson()).toJson(note));
        return REGISTER_RETROFIT.create(CreateToDoServices.class).createNote(requestBody, token);
    }
}
