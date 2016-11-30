package com.gvn.pets.model.http.api;

import com.gvn.pets.base.model.ServerRequest;

/**
 * Created by namIT on 11/28/2016.
 */

public class MeetPeopleRequest extends ServerRequest {

    private static final long serialVersionUID = 4836433590938957530L;

    private int lower_age;
    private int upper_age;
    private double longitude;
    private double latitude;
    private int distance;
    private int skip;
    private int take;
    private boolean is_new_login;
    private int sort_type;
    private int body;
    private int avatar;
    private int filter;
    private int[] region;
    private String token;

    public MeetPeopleRequest(String token, int sort_type, int filter,
                             boolean is_new_login, int lower_age, int upper_age,
                             double longitude, double latitude, int distance, int[] regions, int body, int avatar,
                             int skip, int take) {
        super("meet_people");
        this.token = token;
        this.sort_type = sort_type;
        this.lower_age = lower_age;
        this.upper_age = upper_age;
        this.longitude = longitude;
        this.latitude = latitude;
        this.distance = distance;
        this.skip = skip;
        this.take = take;
        this.is_new_login = is_new_login;
        this.filter = filter;
        this.region = regions;
        this.body = body;
        this.avatar = avatar;
    }

    public int getLower_age() {
        return lower_age;
    }

    public void setLower_age(int lower_age) {
        this.lower_age = lower_age;
    }

    public int getUpper_age() {
        return upper_age;
    }

    public void setUpper_age(int upper_age) {
        this.upper_age = upper_age;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getSkip() {
        return skip;
    }

    public void setSkip(int skip) {
        this.skip = skip;
    }

    public int getTake() {
        return take;
    }

    public void setTake(int take) {
        this.take = take;
    }

    public boolean is_new_login() {
        return is_new_login;
    }

    public void setIs_new_login(boolean is_new_login) {
        this.is_new_login = is_new_login;
    }

    public int getSort_type() {
        return sort_type;
    }

    public void setSort_type(int sort_type) {
        this.sort_type = sort_type;
    }

    public int getBody() {
        return body;
    }

    public void setBody(int body) {
        this.body = body;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public int getFilter() {
        return filter;
    }

    public void setFilter(int filter) {
        this.filter = filter;
    }

    public int[] getRegion() {
        return region;
    }

    public void setRegion(int[] region) {
        this.region = region;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
