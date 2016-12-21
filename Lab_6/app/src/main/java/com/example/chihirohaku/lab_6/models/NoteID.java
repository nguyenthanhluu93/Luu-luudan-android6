package com.example.chihirohaku.lab_6.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Chihirohaku on 12/20/2016.
 */

public class NoteID {
    @SerializedName("$oid")
    private String oId;

    public NoteID(String oId) {
        this.oId = oId;
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    @Override
    public String toString() {
        return "NoteID{" +
                "oId='" + oId + '\'' +
                '}';
    }
}
