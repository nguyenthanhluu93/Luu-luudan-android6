package com.luunt.simplelistnote.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Chihirohaku on 11/8/2016.
 */
public class Note implements Serializable {

    private String name;

    public static final int OP_ADD = 0;
    public static final int OP_UPDATE = 1;

    public Note() {
    }

    public Note(String name, String gender, int age) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name.substring(0, name.indexOf("\n"));

    }

    final static Note[] NAMES = {};
    public static ArrayList<Note> list = new ArrayList<>(Arrays.asList(NAMES));
}
