package com.example.chihirohaku.lab_6.models;

/**
 * Created by Chihirohaku on 12/25/2016.
 */

public class Color {
    private String key;
    private String name;

    public Color(String name, String key) {
        this.name = name;
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
