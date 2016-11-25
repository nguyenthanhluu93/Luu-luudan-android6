package com.gvn.pets.base.model;

/**
 * Created by namIT on 11/24/2016.
 */

public class ServerRequest {
    public String api;
    public String token;

    public ServerRequest(String token, String api) {
        this.token = token;
        this.api = api;
    }
}
