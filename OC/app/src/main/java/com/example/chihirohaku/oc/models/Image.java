package com.example.chihirohaku.oc.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Chihirohaku on 12/18/2016.
 */

public class Image {
    @SerializedName("type")
    private String type;
    @SerializedName("url")
    private String urlImage;

    public Image(String type, String urlImage) {
        this.type = type;
        this.urlImage = urlImage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    @Override
    public String toString() {
        return "Image{" +
                "type='" + type + '\'' +
                ", urlImage='" + urlImage + '\'' +
                '}';
    }
}
