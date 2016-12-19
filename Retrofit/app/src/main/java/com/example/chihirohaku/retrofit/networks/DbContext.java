package com.example.chihirohaku.retrofit.networks;

import com.example.chihirohaku.retrofit.networks.github.jsonmodels.Repo;
import com.example.chihirohaku.retrofit.networks.github.services.GitHubService;

import java.util.List;

import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by Chihirohaku on 12/6/2016.
 */

public class DbContext {

    // GET GITHUB
    public static final Retrofit GITHUB = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static Call<List<Repo>> getGitHubRepos(String username) {
        return GITHUB.create(GitHubService.class).listRepos(username);
    }

    // POST ASERVER
    public static final Retrofit ASERVER = new Retrofit.Builder()
            .baseUrl("https://a-server.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


}
