package com.example.chihirohaku.realmintroinclass.databases.models;

import io.realm.RealmObject;

/**
 * Created by Chihirohaku on 12/6/2016.
 */

public class Person extends RealmObject {

    private String name;
    private long id;

    public static Person create(String name) {
        Person person = new Person();
        person.name = name;

        return person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
