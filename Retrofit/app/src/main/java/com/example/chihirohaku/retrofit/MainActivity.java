package com.example.chihirohaku.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.chihirohaku.retrofit.networks.DbContext;
import com.example.chihirohaku.retrofit.networks.aserver.jsonmodels.RegisterRequestBody;
import com.example.chihirohaku.retrofit.networks.aserver.jsonmodels.RegisterResponseBody;
import com.example.chihirohaku.retrofit.networks.aserver.services.RegisterService;
import com.example.chihirohaku.retrofit.networks.github.jsonmodels.Repo;
import com.example.chihirohaku.retrofit.networks.github.services.GitHubService;
import com.google.gson.Gson;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        sendGET();

        DbContext.getGitHubRepos("nguyenthanhluu93").enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {

            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }
        });

        sendPOST();

    }

    public void sendGET() {
         // 1: create a retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 2: create services
        GitHubService gitHubService = retrofit.create(GitHubService.class);

        // 3: create call
        Call<List<Repo>> call = gitHubService.listRepos("nguyenthanhluu93");

        // 4: send request
        call.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                Log.d(TAG, String.format("onResponse: %s", response));
                List<Repo> repoList = response.body();
                for (Repo repo : repoList) {
                    Log.d(TAG, repo.toString());
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                Log.d(TAG, String.format("onFailure: %s", t));
            }
        });
    }

    public void sendPOST() {
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://a-server.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegisterService registerService = retrofit.create(RegisterService.class);

        RegisterRequestBody registerRequestBody = new RegisterRequestBody(
                "xxxx",
                "xxxx",
                "email@gmail.com",
                "xxxx",
                12,
                12,
                1212
        );

        RequestBody requestBody = RequestBody.create(
                MediaType.parse("application/json"),
                (new Gson()).toJson(registerRequestBody));

        Call<RegisterResponseBody> register = registerService.register(requestBody);
        register.enqueue(new Callback<RegisterResponseBody>() {
            @Override
            public void onResponse(Call<RegisterResponseBody> call, Response<RegisterResponseBody> response) {
                Log.d(TAG, String.format("onResponse: %s", response.body().toString()));
            }

            @Override
            public void onFailure(Call<RegisterResponseBody> call, Throwable t) {
                Log.d(TAG, String.format("onFailure: %s", t));
            }
        });
    }

}
