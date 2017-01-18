package com.example.chihirohaku.musicapp.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Chihirohaku on 1/12/2017.
 */

public class ResponseSong {
    @SerializedName("feed")
    private Feed feed;

    public ResponseSong(Feed feed) {
        this.feed = feed;
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    @Override
    public String toString() {
        return "ResponseSong{" +
                "feed=" + feed +
                '}';
    }
}
