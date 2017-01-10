package com.example.chihirohaku.musicapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Chihirohaku on 1/10/2017.
 */

public class ResponseMusic {
    @SerializedName("id")
    private int id;
    @SerializedName("subgenres")
    private List<Subgenres> subgenres;

    public ResponseMusic(int id, List<Subgenres> subgenres) {
        this.id = id;
        this.subgenres = subgenres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Subgenres> getSubgenres() {
        return subgenres;
    }

    public void setSubgenres(List<Subgenres> subgenres) {
        this.subgenres = subgenres;
    }

    @Override
    public String toString() {
        return "ResponseMusic{" +
                "id=" + id +
                ", subgenres=" + subgenres +
                '}';
    }
}
