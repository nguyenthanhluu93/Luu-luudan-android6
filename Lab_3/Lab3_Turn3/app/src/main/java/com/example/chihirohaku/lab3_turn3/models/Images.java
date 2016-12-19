package com.example.chihirohaku.lab3_turn3.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Chihirohaku on 11/27/2016.
 */

public class Images {

    @SerializedName("url")
    private String url;
    @SerializedName("thumb")
    private String thumb;
    @SerializedName("description")
    private String description;
    @SerializedName("title")
    private String title;

    public Images(String url, String thumb, String description, String title) {
        this.url = url;
        this.thumb = thumb;
        this.description = description;
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Images{" +
                "url='" + url + '\'' +
                ", thumb='" + thumb + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
