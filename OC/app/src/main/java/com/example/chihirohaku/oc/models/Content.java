package com.example.chihirohaku.oc.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Chihirohaku on 12/18/2016.
 */

public class Content {
    @SerializedName("items")
    private List<Company> companyList;

    public Content(List<Company> companyList) {
        this.companyList = companyList;
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    @Override
    public String toString() {
        return "Content{" +
                "companyList=" + companyList +
                '}';
    }
}
