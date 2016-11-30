package com.gvn.pets.model.http.api;

import com.google.gson.annotations.SerializedName;
import com.gvn.pets.base.model.ServerRequest;

/**
 * Created by namIT on 11/29/2016.
 */

public class GetUpdateInfoFlagRequest extends ServerRequest {

    private static final long serialVersionUID = -3977640874891497666L;

    @SerializedName("token")
    private String token;

    public GetUpdateInfoFlagRequest(String token) {
        super("get_update_info_flag");
        this.token = token;
    }
}
