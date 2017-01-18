package com.example.chihirohaku.musicapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Chihirohaku on 1/12/2017.
 */

public class Feed {
    @SerializedName("entry")
    private List<Entry> entries;

    public Feed(List<Entry> entries) {
        this.entries = entries;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    @Override
    public String toString() {
        return "Feed{" +
                "entries=" + entries +
                '}';
    }
}
