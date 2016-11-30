package com.gvn.pets.model.http.api;

/**
 * Created by namIT on 11/29/2016.
 */

public class LoginByFacebookRequest extends LoginRequest {

    private static final long serialVersionUID = 3291744951370758177L;

    protected String fb_id;

    public LoginByFacebookRequest(String fb_id, String device_id,
                                  String notify_token, String login_time, String appVersion, String device_name, String os_version, String gps_adid) {
        super(device_id, notify_token, login_time, appVersion, device_name, os_version, gps_adid);
        this.fb_id = fb_id;
    }
}
