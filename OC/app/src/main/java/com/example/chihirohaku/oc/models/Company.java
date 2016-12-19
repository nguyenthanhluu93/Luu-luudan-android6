package com.example.chihirohaku.oc.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Chihirohaku on 12/18/2016.
 */

public class Company {
    @SerializedName("name")
    private String name;
    @SerializedName("images")
    private List<Image> imageList;

    public Company(String name, List<Image> imageList) {
        this.name = name;
        this.imageList = imageList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", imageList=" + imageList +
                '}';
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public static List<Company> COMPANIES;
}
