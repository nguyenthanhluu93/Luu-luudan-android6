package com.gvn.pets.model.http.api;

import com.gvn.pets.base.model.ServerRequest;

/**
 * Created by namIT on 11/24/2016.
 */

public class TestRequest extends ServerRequest {
    public final int take;
    public final String time_stamp;

    public TestRequest(String api,String token, int take, String time_stamp) {
        super(token,api);
        this.take = take;
        this.time_stamp = time_stamp;
    }
}
