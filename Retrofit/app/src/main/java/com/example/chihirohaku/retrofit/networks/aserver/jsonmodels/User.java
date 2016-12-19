package com.example.chihirohaku.retrofit.networks.aserver.jsonmodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Chihirohaku on 12/6/2016.
 */

public class User {

//    @SerializedName("Email")
//    private String email;
//    @SerializedName("AccessToken")
//    private String token;
//    @SerializedName("DayOfBirth")
//    private int dayOfBirth;
//    @SerializedName("MonthOfBirth")
//    private int monthOfBirth;
//    @SerializedName("Phone")
//    private String phone;

    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("AccessToken")
    @Expose
    private String accessToken;
    @SerializedName("DayOfBirth")
    @Expose
    private Integer dayOfBirth;
    @SerializedName("MonthOfBirth")
    @Expose
    private Integer monthOfBirth;
    @SerializedName("Phone")
    @Expose
    private String phone;
    @SerializedName("YearOfBirth")
    @Expose
    private Integer yearOfBirth;
    @SerializedName("CustomerName")
    @Expose
    private String customerName;
    @SerializedName("Id")
    @Expose
    private Integer id;

    public String getEmail() {
        return email;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public Integer getDayOfBirth() {
        return dayOfBirth;
    }

    public Integer getMonthOfBirth() {
        return monthOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", dayOfBirth=" + dayOfBirth +
                ", monthOfBirth=" + monthOfBirth +
                ", phone='" + phone + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", customerName='" + customerName + '\'' +
                ", id=" + id +
                '}';
    }
}
