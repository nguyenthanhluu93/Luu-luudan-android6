package com.example.chihirohaku.musicapp.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Chihirohaku on 2/7/2017.
 */

public class Docs {
    @SerializedName("link_download")
    private LinkDownload linkDownload;
    @SerializedName("source")
    private Source source;

    public LinkDownload getLinkDownload() {
        return linkDownload;
    }

    public void setLinkDownload(LinkDownload linkDownload) {
        this.linkDownload = linkDownload;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "Docs{" +
                "linkDownload=" + linkDownload +
                ", source=" + source +
                '}';
    }
}
