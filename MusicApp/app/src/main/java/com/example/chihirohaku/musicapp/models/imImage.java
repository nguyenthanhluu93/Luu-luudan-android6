package com.example.chihirohaku.musicapp.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Chihirohaku on 1/12/2017.
 */

public class imImage {
    @SerializedName("label")
    private String label;

    public imImage(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "imImage{" +
                "label='" + label + '\'' +
                '}';
    }
}
