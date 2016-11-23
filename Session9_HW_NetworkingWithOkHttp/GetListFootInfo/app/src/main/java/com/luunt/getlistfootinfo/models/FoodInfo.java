package com.luunt.getlistfootinfo.models;

/**
 * Created by Chihirohaku on 11/23/2016.
 */
public class FoodInfo {

    private int price;
    private String detail;
    private String image;
    private String name;

    public FoodInfo(int price, String detail, String image, String name) {
        this.price = price;
        this.detail = detail;
        this.image = image;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FoodInfo{" +
                "price=" + price +
                ", detail='" + detail + '\'' +
                ", image='" + image + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
