package com.example.chihirohaku.lab5.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Chihirohaku on 12/11/2016.
 */

public class ResquestBody {
    @SerializedName("Id")
    private int id;
    @SerializedName("Name")
    private String name;
    @SerializedName("Description")
    private String description;

    public ResquestBody() {
    }
}
