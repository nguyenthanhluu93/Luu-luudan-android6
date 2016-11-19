package com.luunt.sqliteintro.models;

/**
 * Created by Chihirohaku on 11/15/2016.
 */
public class Note {

    private int id;
    private String title;
    private String content;
    private String dateCreated;

    public Note(String title, String content, String dateCreated) {
        this(-1, title, content, dateCreated);
    }

    public Note(int id, String title, String content, String dateCreated) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.dateCreated = dateCreated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                '}';
    }
}
