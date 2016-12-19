package com.example.chihirohaku.lab5.models;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by Chihirohaku on 12/11/2016.
 */

public class Thumb extends RealmObject {
    @SerializedName("url")
    private String url;
    @SerializedName("thumb")
    private String thumb;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;

    public Thumb() {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Thumb{" +
                "url='" + url + '\'' +
                ", thumb='" + thumb + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
