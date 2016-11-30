package com.gvn.pets.model.http.api;

import com.google.gson.annotations.SerializedName;
import com.gvn.pets.base.model.ServerRequest;

/**
 * Created by namIT on 11/29/2016.
 */

public class InstallCountRequest extends ServerRequest {

    private static final long serialVersionUID = -6492918834397084435L;

    // int : 0 : IOS | 1: Android
    @SerializedName("device_type")
    private int device_type;
    @SerializedName("unique_number")
    private String unique_number;

    public InstallCountRequest(int device_type, String unique_number) {
        super("install_application");
        this.device_type = device_type;
        this.unique_number = unique_number;
    }
}
