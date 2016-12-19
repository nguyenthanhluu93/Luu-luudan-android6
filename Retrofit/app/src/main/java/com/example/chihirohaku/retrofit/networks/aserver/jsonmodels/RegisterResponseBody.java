package com.example.chihirohaku.retrofit.networks.aserver.jsonmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Chihirohaku on 12/6/2016.
 */

public class RegisterResponseBody {
    @SerializedName("d")
    private User user;

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "RegisterResponseBody{" +
                "user=" + user +
                '}';
    }
}
