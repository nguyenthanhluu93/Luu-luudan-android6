package com.example.chihirohaku.musicapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmObject;

/**
 * Created by Chihirohaku on 1/14/2017.
 */

public class SongRealm extends RealmObject {

    private String songName;
    private String urlImageSong;
    private String artistName;

    public SongRealm() {
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getUrlImageSong() {
        return urlImageSong;
    }

    public void setUrlImageSong(String urlImageSong) {
        this.urlImageSong = urlImageSong;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}
