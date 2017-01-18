package com.example.chihirohaku.musicapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Chihirohaku on 1/14/2017.
 */

public class SubgenresRealm extends RealmObject {

    private String id;
    private String nameSubgenres;
    private RealmList<SongRealm> songRealmList;
    private boolean isLike;

    public SubgenresRealm() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameSubgenres() {
        return nameSubgenres;
    }

    public void setNameSubgenres(String nameSubgenres) {
        this.nameSubgenres = nameSubgenres;
    }

    public RealmList<SongRealm> getSongRealmList() {
        return songRealmList;
    }

    public void setSongRealmList(RealmList<SongRealm> songList) {
        songRealmList = new RealmList<>();
        for (SongRealm songRealm : songList) {
            songRealmList.add(songRealm);
        }
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

}
