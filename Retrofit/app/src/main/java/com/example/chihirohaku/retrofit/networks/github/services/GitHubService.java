package com.example.chihirohaku.retrofit.networks.github.services;

import com.example.chihirohaku.retrofit.networks.github.jsonmodels.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Chihirohaku on 12/6/2016.
 */

public interface GitHubService {
    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String userName);

}
