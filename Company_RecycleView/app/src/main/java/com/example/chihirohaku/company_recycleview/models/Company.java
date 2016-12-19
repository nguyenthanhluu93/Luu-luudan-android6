package com.example.chihirohaku.company_recycleview.models;

/**
 * Created by Chihirohaku on 12/13/2016.
 */

public class Company {

    private String imageUrl;
    private String name;

    public Company(String imageUrl, String name) {
        this.imageUrl = imageUrl;
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Company COMPANYS[] = new Company[] {
                    new Company("FPT Software", "https://www.fpt-software.com")
                    , new Company("EWay", "https://eway.vn")
                    , new Company("KMS", "http://www.kms-technology.com")
                    , new Company("BraveBits", "http://www.bravebits.vn")
                    , new Company("TechKids", "http://techkids.vn")
    };
}
