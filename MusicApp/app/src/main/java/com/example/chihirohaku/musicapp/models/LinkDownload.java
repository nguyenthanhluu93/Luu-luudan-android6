package com.example.chihirohaku.musicapp.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Chihirohaku on 2/7/2017.
 */

public class LinkDownload {
    @SerializedName("128")
    private String linkDownload;

    public String getLinkDownload() {
        return linkDownload;
    }

    public void setLinkDownload(String linkDownload) {
        this.linkDownload = linkDownload;
    }

    @Override
    public String toString() {
        return "LinkDownload{" +
                "linkDownload='" + linkDownload + '\'' +
                '}';
    }
}
