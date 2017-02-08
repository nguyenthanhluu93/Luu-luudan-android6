package com.example.chihirohaku.musicapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Chihirohaku on 2/7/2017.
 */

public class ResponseDataSong {
    @SerializedName("docs")
    private ArrayList<Docs> docses;

    public ArrayList<Docs> getDocses() {
        return docses;
    }

    public void setDocses(ArrayList<Docs> docses) {
        this.docses = docses;
    }

    @Override
    public String toString() {
        return "ResponseDataSong{" +
                "docses=" + docses +
                '}';
    }
}
