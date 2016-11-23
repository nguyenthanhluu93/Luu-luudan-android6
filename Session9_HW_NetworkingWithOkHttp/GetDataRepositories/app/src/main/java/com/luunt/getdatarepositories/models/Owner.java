package com.luunt.getdatarepositories.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Chihirohaku on 11/24/2016.
 */
public class Owner {

    @SerializedName("login")
    private String loginUser;
    @SerializedName("avatar_url")
    private String avatarUrl;

    public Owner(String loginUser, String avatarUrl) {
        this.loginUser = loginUser;
        this.avatarUrl = avatarUrl;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
