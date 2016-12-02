package com.gvn.pets.model.bean;

import com.gvn.pets.app.AppController;
import com.gvn.pets.utils.SystemUtils;
import com.gvn.pets.utils.TimeUtils;
import com.gvn.pets.utils.prefers.AppPreference;
import com.gvn.pets.utils.prefers.UserPreference;

/**
 * Created by namIT on 12/2/2016.
 */

public class UserLogin {
    String email;
    String facebookId;
    String pass;
    String deviceId;
    String notifyToken;
    String loginTime;
    String appVersion;
    String deviceName;
    String osVersion;
    String gpsAdid;

    public UserLogin(String email, String facebookId, String pass, String deviceId, String notifyToken, String loginTime, String appVersion, String deviceName, String osVersion, String gpsAdid) {
        this.email = email;
        this.facebookId = facebookId;
        this.pass = pass;
        this.deviceId = deviceId;
        this.notifyToken = notifyToken;
        this.loginTime = loginTime;
        this.appVersion = appVersion;
        this.deviceName = deviceName;
        this.osVersion = osVersion;
        this.gpsAdid = gpsAdid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getNotifyToken() {
        return notifyToken;
    }

    public void setNotifyToken(String notifyToken) {
        this.notifyToken = notifyToken;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getGpsAdid() {
        return gpsAdid;
    }

    public void setGpsAdid(String gpsAdid) {
        this.gpsAdid = gpsAdid;
    }

    public static synchronized UserLogin onAutoLogin() {
        UserPreference userPreferences = UserPreference.getInstance();

        // Authentication data
        String email = userPreferences.getEmail();
        String facebookId = userPreferences.getFacebookId();
        String pass = userPreferences.getPassword();
        // Get basic login data
        String device_id = SystemUtils.getDeviceId();
        String notify_token = AppPreference.getInstance().getGCMResitrationId();
        String login_time = TimeUtils.getLoginTime();
        String appVersion = SystemUtils.getAppVersionName(AppController.getInstance());
        String device_name = SystemUtils.getDeviceName();
        String os_version = SystemUtils.getAndroidOSVersion();
        String gps_adid = AppPreference.getInstance().getGPSADID();
        return new UserLogin(email, facebookId, pass, device_id, notify_token, login_time, appVersion, device_name, os_version, gps_adid);
    }
}