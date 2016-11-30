package com.gvn.pets.base.model;

import java.io.Serializable;

/**
 * Created by namIT on 11/24/2016.
 */

public class ServerRequest implements Serializable {
    public String api;

    public ServerRequest(String api) {
        this.api = api;
    }
}
