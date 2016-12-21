package com.example.chihirohaku.lab_6.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Chihirohaku on 12/18/2016.
 */

public class Account {

    public static final String DATA = "my_sharepreferences";
    public static final String TOKEN = "key_token";

    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
