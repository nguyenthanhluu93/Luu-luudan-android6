package com.example.chihirohaku.lab3_turn3.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Chihirohaku on 11/27/2016.
 */

public class Hair {

    @SerializedName("Description")
    private String description;
    @SerializedName("Images")
    private ArrayList<Images> imagesList;
    @SerializedName("Id")
    private int id;

    public Hair(String description, ArrayList<Images> imagesList, int id) {
        this.description = description;
        this.imagesList = imagesList;
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Images> getImagesList() {
        return imagesList;
    }

    public void setImagesList(ArrayList<Images> imagesList) {
        this.imagesList = imagesList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Hair{" +
                "description='" + description + '\'' +
                ", imagesList=" + imagesList +
                ", id=" + id +
                '}';
    }
}
