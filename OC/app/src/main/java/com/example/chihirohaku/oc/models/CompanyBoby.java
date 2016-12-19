package com.example.chihirohaku.oc.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Chihirohaku on 12/18/2016.
 */

public class CompanyBoby {
    @SerializedName("content")
    private Content content;

    public CompanyBoby(Content content) {
        this.content = content;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CompanyBoby{" +
                "content=" + content +
                '}';
    }
}
