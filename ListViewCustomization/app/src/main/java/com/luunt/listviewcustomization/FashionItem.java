package com.luunt.listviewcustomization;

/**
 * Created by Chihirohaku on 11/20/2016.
 */
public class FashionItem {

    private String title;
    private int imResId;

    public FashionItem(String title, int imResId) {
        this.title = title;
        this.imResId = imResId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImResId() {
        return imResId;
    }

    public void setImResId(int imResId) {
        this.imResId = imResId;
    }

    @Override
    public String toString() {
        return this.title;
    }

    public static final FashionItem[] ARRAY = new FashionItem[] {
            new FashionItem("Women", R.drawable.women_fashion),
            new FashionItem("Men", R.drawable.men_fashion),
            new FashionItem("Kids", R.drawable.kids_fashion)
    };

}
