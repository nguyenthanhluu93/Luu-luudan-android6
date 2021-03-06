package com.gvn.pets.model.http.api;

import com.google.gson.annotations.SerializedName;
import com.gvn.pets.base.model.ServerRequest;

/**
 * Created by namIT on 11/29/2016.
 */

public class GetUserStatusRequest extends ServerRequest {

    private static final long serialVersionUID = -6414097888442971746L;

    public static final int TYPE_NONE = 0;
    public static final int TYPE_EMAIL = 1;
    public static final int TYPE_FACEBOOK = 2;
    public static final int TYPE_MOCOM = 3;
    public static final int TYPE_FAMU = 4;

    @SerializedName("email")
    private String email;
    @SerializedName("fb_id")
    private String fb_id;
    @SerializedName("mocom_id")
    private String mocom_id;
    @SerializedName("famu_id")
    private String famu_id;

    public GetUserStatusRequest(int type, String data) {
        super("get_user_status_by_email");
        switch (type) {
            case TYPE_EMAIL:
                this.email = data;
                break;
            case TYPE_FACEBOOK:
                this.fb_id = data;
                break;
            case TYPE_MOCOM:
                this.mocom_id = data;
                break;
            case TYPE_FAMU:
                this.famu_id = data;
                break;

            default:
                break;
        }
    }
}
