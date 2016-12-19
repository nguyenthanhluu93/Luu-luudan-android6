package com.example.chihirohaku.lab5.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Chihirohaku on 12/11/2016.
 */

public class ResponData extends RealmObject {
    @SerializedName("d")
    private RealmList<Home> homeArrayList;

    public RealmList<Home> getHomeArrayList() {
        return homeArrayList;
    }

    public void setHomeArrayList(RealmList<Home> homeArrayList) {
        this.homeArrayList = homeArrayList;
    }

    public ResponData() {
    }

    @Override
    public String toString() {
        return "ResponData{" +
                "homeArrayList=" + homeArrayList +
                '}';
    }
}
