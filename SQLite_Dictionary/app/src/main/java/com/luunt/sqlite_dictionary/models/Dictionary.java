package com.luunt.sqlite_dictionary.models;

import java.io.Serializable;

/**
 * Created by Chihirohaku on 11/19/2016.
 */
public class Dictionary implements Serializable {

    private int id;
    private String original_word;
    private String translated_word;
    private String date_created;
    private int is_favorite;
    public static String WORD = "word";

    public Dictionary(int id, String original_word, String translated_word, String date_created, int is_favorite) {
        this.id = id;
        this.original_word = original_word;
        this.translated_word = translated_word;
        this.date_created = date_created;
        this.is_favorite = is_favorite;
    }

    public Dictionary(String original_word, String translated_word, String date_created, int is_favorite) {
        this(-1, original_word, translated_word, date_created, is_favorite);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginal_word() {
        return original_word;
    }

    public void setOriginal_word(String original_word) {
        this.original_word = original_word;
    }

    public String getTranslated_word() {
        return translated_word;
    }

    public void setTranslated_word(String translated_word) {
        this.translated_word = translated_word;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public int getIs_favorite() {
        return is_favorite;
    }

    public void setIs_favorite(int is_favorite) {
        this.is_favorite = is_favorite;
    }

    //    @Override
//    public String toString() {
//        return "Dictionary{" +
//                "id=" + id +
//                ", original_word='" + original_word + '\'' +
//                ", translated_word='" + translated_word + '\'' +
//                ", date_created='" + date_created + '\'' +
//                ", is_favorite=" + is_favorite +
//                '}';
//    }


    @Override
    public String toString() {
        return this.original_word;
    }
}
