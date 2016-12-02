package com.gvn.pets.model.http.api;

import com.google.gson.annotations.SerializedName;
import com.gvn.pets.model.bean.UserLogin;

/**
 * Created by namIT on 11/29/2016.
 */

public class LoginByEmailRequest extends LoginRequest {

    private static final long serialVersionUID = 9091499558737348397L;

    @SerializedName("email")
    protected String email;
    @SerializedName("pwd")
    protected String pwd;

    public LoginByEmailRequest(String email, String password, String device_id,
                                  String notify_token, String login_time, String appVersion, String device_name, String os_version, String gps_adid) {
        super(device_id, notify_token, login_time, appVersion, device_name, os_version, gps_adid);
        this.email = email;
        this.pwd = password;
    }

    public LoginByEmailRequest(UserLogin userLogin) {
        super(userLogin.getDeviceId(), userLogin.getNotifyToken(), userLogin.getLoginTime(), userLogin.getAppVersion(), userLogin.getDeviceName(), userLogin.getOsVersion(), userLogin.getGpsAdid());
        this.email = userLogin.getEmail();
        this.pwd = userLogin.getPass();
    }
}
