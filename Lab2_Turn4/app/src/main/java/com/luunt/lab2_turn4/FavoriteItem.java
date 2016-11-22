package com.luunt.lab2_turn4;

import android.content.Context;
import android.util.Log;

/**
 * Created by Chihirohaku on 11/20/2016.
 */
public class FavoriteItem {

    private String content;
    private String time;
    private int imgFavorite;

    public FavoriteItem(String content, String time, int imgFavorite) {
        this.content = content;
        this.time = time;
        this.imgFavorite = imgFavorite;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImgFavorite() {
        return imgFavorite;
    }

    public void setImgFavorite(int imgFavorite) {
        this.imgFavorite = imgFavorite;
    }

    @Override
    public String toString() {
        return this.content;
    }

//    static Context context;
//    static String c1 = context.getString(R.string.content1);

    public static FavoriteItem[] ARRAY = new FavoriteItem[] {
            new FavoriteItem("He may act like he wants a secretary but most of the time they’re looking for…", "13 min", R.drawable.item2),
            new FavoriteItem("Peggy, just think about it. Deeply. Then forget it. And an idea will jump up on your face", "13 min", R.drawable.item3),
            new FavoriteItem("Go home, take a paper bag and cut some eyeholes out of it. Put it over your head", "14 min", R.drawable.item4),
            new FavoriteItem("Get out of here and move forward. This never happened. It will shock you how much", "1 hour", R.drawable.item5)
    };
}
