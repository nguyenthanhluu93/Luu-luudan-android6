package com.example.chihirohaku.lab_6.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chihirohaku on 12/20/2016.
 */

public class Note {
    @SerializedName("content")
    private String content;
    @SerializedName("completed")
    private boolean isComplete;
    @SerializedName("_id")
    private NoteID id;
    @SerializedName("color")
    private String color;
    @SerializedName("title")
    private String title;

    public Note(String content, boolean isComplete, String color, String title) {
        this.content = content;
        this.isComplete = isComplete;
        this.color = color;
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public NoteID getId() {
        return id;
    }

    public void setId(NoteID id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Note{" +
                "content='" + content + '\'' +
                ", isComplete=" + isComplete +
                ", id=" + id +
                ", color='" + color + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public static ArrayList<Note> notes;
}
