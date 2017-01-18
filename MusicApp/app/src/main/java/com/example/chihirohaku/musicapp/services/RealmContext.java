package com.example.chihirohaku.musicapp.services;

import android.content.Context;

import com.example.chihirohaku.musicapp.models.SongRealm;
import com.example.chihirohaku.musicapp.models.SubgenresRealm;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;

/**
 * Created by Chihirohaku on 1/14/2017.
 */

public class RealmContext {

    private Realm realm;

    public RealmContext() {
        realm = Realm.getDefaultInstance();
    }

    public void insert(List<SubgenresRealm> subgenresRealmList) {
        // 3: add to realm
        realm.beginTransaction();
        for (SubgenresRealm subgenresRealm : subgenresRealmList) {
            realm.copyToRealm(subgenresRealm);
        }
        realm.commitTransaction();
    }

    public List<SubgenresRealm> allSubgenres() {
        return realm.where(SubgenresRealm.class).findAll();
    }

    public void deleteAll() {
        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();
    }

    public void updateSongToGenres(SubgenresRealm subgenresRealm, RealmList<SongRealm> songRealmList) {
        realm.beginTransaction();
        subgenresRealm.setSongRealmList(songRealmList);
        realm.commitTransaction();
    }

    private static RealmContext instance;
    public static RealmContext getInstance() {
        return instance;
    }

    public static void init(Context context) {
        Realm.init(context);
        instance = new RealmContext();
    }
}
