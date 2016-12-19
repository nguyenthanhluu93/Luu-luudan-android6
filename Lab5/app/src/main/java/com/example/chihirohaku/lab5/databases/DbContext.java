package com.example.chihirohaku.lab5.databases;

import android.content.Context;

import com.example.chihirohaku.lab5.models.Home;
import com.example.chihirohaku.lab5.models.ResponData;

import java.util.List;

import io.realm.Realm;

/**
 * Created by Chihirohaku on 12/6/2016.
 */

public class DbContext {

    private Realm realm;

    public DbContext() {
        realm = Realm.getDefaultInstance();
    }

    public void insert(Home home) {
        // 3: add to realm
        realm.beginTransaction();
        realm.copyToRealm(home);
        realm.commitTransaction();
    }

    public List<Home> allData() {
        return realm.where(Home.class).findAll();
    }

    public void deleteAll() {
        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();
    }

//    public void update(Person person, String name) {
//        realm.beginTransaction();
//        person.setName(name);  // managed
//        realm.commitTransaction();
//    }
//
//    public void delete(Person p) {
//        realm.beginTransaction();
//        p.deleteFromRealm();
//        realm.commitTransaction();
//    }

    private static DbContext instance;
    public static DbContext getInstance() {
        return instance;
    }

    public static void init(Context context) {
        Realm.init(context);
        instance = new DbContext();
    }
}
