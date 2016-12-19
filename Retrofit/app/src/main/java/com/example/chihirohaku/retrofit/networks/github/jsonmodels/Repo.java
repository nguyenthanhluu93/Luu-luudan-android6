package com.example.chihirohaku.retrofit.networks.github.jsonmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Chihirohaku on 12/6/2016.
 */

public class Repo {

    class Owner {
        @SerializedName("login")
        private String login;
        @SerializedName("avatar_url")
        private String avatarUrl;

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        @Override
        public String toString() {
            return "Owner{" +
                    "login='" + login + '\'' +
                    ", avatarUrl='" + avatarUrl + '\'' +
                    '}';
        }
    }

    @SerializedName("id")
    private long id;
    @SerializedName("name")
    private String name;

    @SerializedName("owner")
    private Owner owner;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Repo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                '}';
    }
}
