package com.example.chihirohaku.musicapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chihirohaku on 1/10/2017.
 */

public class Subgenres {
    @SerializedName("id")
    private String id_img;
    @SerializedName("translation_key")
    private String translationKey;

    public Subgenres(String id_img, String translationKey) {
        this.id_img = id_img;
        this.translationKey = translationKey;
    }

    public String getId_img() {
        return id_img;
    }

    public void setId_img(String id_img) {
        this.id_img = id_img;
    }

    public String getTranslationKey() {
        return translationKey;
    }

    public void setTranslationKey(String translationKey) {
        this.translationKey = translationKey;
    }

    @Override
    public String toString() {
        return "Subgenres{" +
                "id_img=" + id_img +
                ", translationKey='" + translationKey + '\'' +
                '}';
    }

    public static List<Subgenres> subgenresList = new ArrayList<>();

    public static List<Subgenres> getSubgenresList() {
        return subgenresList;
    }

    public static void setSubgenresList(List<Subgenres> subgenresList) {
        Subgenres.subgenresList = subgenresList;
    }
}
