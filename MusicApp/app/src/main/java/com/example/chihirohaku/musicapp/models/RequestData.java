package com.example.chihirohaku.musicapp.models;

/**
 * Created by Chihirohaku on 2/7/2017.
 */

public class RequestData {
    private SongRealm songRealm;

    public RequestData(SongRealm songRealm) {
        this.songRealm = songRealm;
    }

    @Override
    public String toString() {
        return "{\"q\":\"" + songRealm.getSongName() + " " + songRealm.getArtistName() +
                "\",\"sort\":\"hot\", \"start\":\"0\", \"length\":\"10\"}";
    }
}
