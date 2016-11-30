package com.gvn.pets.model.bean;

import com.google.gson.annotations.SerializedName;
import com.gvn.pets.base.model.ServerResponse;

/**
 * Created by namIT on 11/29/2016.
 */

public class LoginBean extends ServerResponse {

    private static final long serialVersionUID = -2113288031699486543L;

    @SerializedName("data")
    public AuthenticationBean authenData;
    @SerializedName("backlst")
    public String blockedUserList;
    @SerializedName("get_free_point_android")
    public boolean isEnableGetFreePoint;
    @SerializedName("turn_off_user_info_android")
    public boolean isTurnOffUserInfo;
    @SerializedName("turn_off_show_news_android")
    public boolean isShowNews;
    @SerializedName("switch_browser_android_version")
    public String switchBrowserVersion;
}
