package com.example.chihirohaku.retrofit.networks.aserver.jsonmodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Chihirohaku on 12/6/2016.
 */

public class RegisterRequestBody {
    @SerializedName("Phone")
    @Expose
    private String phone;
    @SerializedName("CustomerName")
    @Expose
    private String customerName;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("Password")
    @Expose
    private String password;
    @SerializedName("DayOfBirth")
    @Expose
    private Integer dayOfBirth;
    @SerializedName("MonthOfBirth")
    @Expose
    private Integer monthOfBirth;
    @SerializedName("YearOfBirth")
    @Expose
    private Integer yearOfBirth;

    public RegisterRequestBody(String phone, String customerName, String email, String password, Integer dayOfBirth, Integer monthOfBirth, Integer yearOfBirth) {
        this.phone = phone;
        this.customerName = customerName;
        this.email = email;
        this.password = password;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return "RegisterRequestBody{" +
                "phone='" + phone + '\'' +
                ", customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dayOfBirth=" + dayOfBirth +
                ", monthOfBirth=" + monthOfBirth +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }
}
