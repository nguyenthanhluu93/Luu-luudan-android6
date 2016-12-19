package com.example.chihirohaku.lab3_turn2.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Chihirohaku on 11/27/2016.
 */

public class Salon {

    @SerializedName("Fanpage")
    private String fanpage;
    @SerializedName("Name")
    private String name;
    @SerializedName("FanpageId")
    private String fanpageId;
    @SerializedName("ManagerName")
    private String managerName;
    @SerializedName("Phone")
    private String phone;
    @SerializedName("Images")
    private ArrayList<Images> imagesList;
    @SerializedName("Id")
    private int id;

    public Salon(String fanpage, String name, String fanpageId, String managerName, String phone, ArrayList<Images> imagesList, int id) {
        this.fanpage = fanpage;
        this.name = name;
        this.fanpageId = fanpageId;
        this.managerName = managerName;
        this.phone = phone;
        this.imagesList = imagesList;
        this.id = id;
    }

    public String getFanpage() {
        return fanpage;
    }

    public void setFanpage(String fanpage) {
        this.fanpage = fanpage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFanpageId() {
        return fanpageId;
    }

    public void setFanpageId(String fanpageId) {
        this.fanpageId = fanpageId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Images> getImagesList() {
        return imagesList;
    }

    public void setImagesList(ArrayList<Images> imagesList) {
        this.imagesList = imagesList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Salon{" +
                "fanpage='" + fanpage + '\'' +
                ", name='" + name + '\'' +
                ", fanpageId='" + fanpageId + '\'' +
                ", managerName='" + managerName + '\'' +
                ", phone='" + phone + '\'' +
                ", imagesList=" + imagesList +
                ", id=" + id +
                '}';
    }
}
