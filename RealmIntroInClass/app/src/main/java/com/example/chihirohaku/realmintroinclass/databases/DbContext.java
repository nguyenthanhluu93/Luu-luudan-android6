package com.example.chihirohaku.realmintroinclass.databases;

import android.content.Context;

import com.example.chihirohaku.realmintroinclass.databases.models.Person;

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

    public void insert(Person person) {
        // 3: add to realm
        realm.beginTransaction();
        realm.copyToRealm(person);
        realm.commitTransaction();
    }

    public List<Person> allPerson() {
        return realm.where(Person.class).findAll();
    }

    public void update(Person person, String name) {
        realm.beginTransaction();
        person.setName(name);  // managed
        realm.commitTransaction();
    }

    public void delete(Person p) {
        realm.beginTransaction();
        p.deleteFromRealm();
        realm.commitTransaction();
    }

    private static DbContext instance;
    public static DbContext getInstance() {
        return instance;
    }

    public static void init(Context context) {
        Realm.init(context);
        instance = new DbContext();
    }
}
