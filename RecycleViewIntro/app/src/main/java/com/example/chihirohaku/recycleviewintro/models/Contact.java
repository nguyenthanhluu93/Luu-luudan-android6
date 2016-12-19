package com.example.chihirohaku.recycleviewintro.models;

/**
 * Created by Chihirohaku on 12/13/2016.
 */

public class Contact {
    private String name;
    private String phone;
    private String imageUrl;

    public Contact(String name, String phone, String imageUrl) {
        this.name = name;
        this.phone = phone;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public static Contact[] CONTACTS = new Contact[] {
            new Contact("Elon mark", "123456", "http://a.abcnews.com/images/Technology/gty_larry_page_google_tk_130514_wmain.jpg"),
            new Contact("aas", "231131", "https://pbs.twimg.com/profile_images/2267320808/9m1dxis8i287vq9rcgvx_400x400.jpeg"),
            new Contact("bsa", "54353", "http://images.huffingtonpost.com/2015-07-17-1437155465-1424656-SteveJobs.jpg"),
            new Contact("casa", "455445", "https://pbs.twimg.com/profile_images/782474226020200448/zDo-gAo0_400x400.jpg"),
            new Contact("sda", "5435353", "https://pbs.twimg.com/profile_images/782474226020200448/zDo-gAo0_400x400.jpg")
    };
}
