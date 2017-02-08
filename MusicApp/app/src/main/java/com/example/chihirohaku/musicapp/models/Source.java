package com.example.chihirohaku.musicapp.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Chihirohaku on 2/7/2017.
 */

public class Source {
    @SerializedName("128")
    private String linkSource;

    public String getLinkSource() {
        return linkSource;
    }

    public void setLinkSource(String linkSource) {
        this.linkSource = linkSource;
    }

    @Override
    public String toString() {
        return "Source{" +
                "linkSource='" + linkSource + '\'' +
                '}';
    }
}
