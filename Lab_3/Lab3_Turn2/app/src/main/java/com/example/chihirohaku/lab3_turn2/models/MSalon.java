package com.example.chihirohaku.lab3_turn2.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Chihirohaku on 11/27/2016.
 */

public class MSalon {

    @SerializedName("d")
    private ArrayList<Salon> salon;

    public MSalon(ArrayList<Salon> salon) {
        this.salon = salon;
    }

    public ArrayList<Salon> getSalon() {
        return salon;
    }

    public void setSalon(ArrayList<Salon> salon) {
        this.salon = salon;
    }

    @Override
    public String toString() {
        return "MSalon{" +
                "salon=" + salon +
                '}';
    }
}
