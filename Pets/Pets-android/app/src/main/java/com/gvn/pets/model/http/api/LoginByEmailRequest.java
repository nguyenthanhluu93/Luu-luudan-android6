package com.gvn.pets.model.http.api;

/**
 * Created by namIT on 11/29/2016.
 */

public class LoginByEmailRequest extends LoginRequest {

    private static final long serialVersionUID = 9091499558737348397L;

    protected String email;
    protected String pwd;

    public LoginByEmailRequest(String email, String password, String device_id,
                                  String notify_token, String login_time, String appVersion, String device_name, String os_version, String gps_adid) {
        super(device_id, notify_token, login_time, appVersion, device_name, os_version, gps_adid);
        this.email = email;
        this.pwd = password;
    }
}
