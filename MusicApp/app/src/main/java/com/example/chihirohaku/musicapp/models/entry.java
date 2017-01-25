package com.example.chihirohaku.musicapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by User on 1/19/2017.
 */

public class Entry {
    @SerializedName("im:name")
    private imName imName;
    @SerializedName("im:image")
    private List<imImage> imImages;
    @SerializedName("im:artist")
    private imArtist imArtist;

    public Entry(com.example.chihirohaku.musicapp.models.imName imName, List<imImage> imImages, com.example.chihirohaku.musicapp.models.imArtist imArtist) {
        this.imName = imName;
        this.imImages = imImages;
        this.imArtist = imArtist;
    }

    public com.example.chihirohaku.musicapp.models.imName getImName() {
        return imName;
    }

    public void setImName(com.example.chihirohaku.musicapp.models.imName imName) {
        this.imName = imName;
    }

    public List<imImage> getImImages() {
        return imImages;
    }

    public void setImImages(List<imImage> imImages) {
        this.imImages = imImages;
    }

    public com.example.chihirohaku.musicapp.models.imArtist getImArtist() {
        return imArtist;
    }

    public void setImArtist(com.example.chihirohaku.musicapp.models.imArtist imArtist) {
        this.imArtist = imArtist;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "imName=" + imName +
                ", imImages=" + imImages +
                ", imArtist=" + imArtist +
                '}';
    }

}
