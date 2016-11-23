package com.luunt.getdatarepositories.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Chihirohaku on 11/24/2016.
 */
public class Repositories {

    @SerializedName("name")
    private String nameUser;
    @SerializedName("owner")
    private Owner ownerUser;

    public Repositories(String nameUser, Owner ownerUser) {
        this.nameUser = nameUser;
        this.ownerUser = ownerUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public Owner getOwnerUser() {
        return ownerUser;
    }

    public void setOwnerUser(Owner ownerUser) {
        this.ownerUser = ownerUser;
    }
}
