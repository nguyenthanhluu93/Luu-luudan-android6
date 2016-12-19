package com.example.chihirohaku.lab_6.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Chihirohaku on 12/18/2016.
 */

public class Status {
    @SerializedName("token")
    private String token;
    @SerializedName("result")
    private String result;
    @SerializedName("message")
    private String message;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Status{" +
                "result='" + result + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
