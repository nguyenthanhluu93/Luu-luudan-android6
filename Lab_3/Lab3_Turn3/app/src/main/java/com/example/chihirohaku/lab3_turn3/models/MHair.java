package com.example.chihirohaku.lab3_turn3.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Chihirohaku on 11/27/2016.
 */

public class MHair {

    @SerializedName("d")
    private ArrayList<Hair> hairs;

    public MHair(ArrayList<Hair> hairs) {
        this.hairs = hairs;
    }

    public ArrayList<Hair> getHairs() {
        return hairs;
    }

    public void setHairs(ArrayList<Hair> hairs) {
        this.hairs = hairs;
    }

    @Override
    public String toString() {
        return "MHair{" +
                "hairs=" + hairs +
                '}';
    }
}
