package com.gvn.pets.model.bean;

import com.google.gson.annotations.SerializedName;
import com.gvn.pets.base.model.ServerResponse;

/**
 * Created by namIT on 11/28/2016.
 */

public class GetApplicationInfoBean extends ServerResponse {

    private static final long serialVersionUID = -9174703502721624612L;
    @SerializedName("data")
    public GetApplicationInfoBean data;
    @SerializedName("switch_browser_android_version")
    public String switchBrowserVersion;
    @SerializedName("switch_browser_android")
    public boolean isSwitchBrowser;
    @SerializedName("login_by_mocom_android")
    public boolean isLoginByAnotherSystem;
    @SerializedName("get_free_point_android")
    public boolean isGetFreePoint;
    @SerializedName("turn_off_user_info_android")
    public boolean isTurnOffUserInfo;
    @SerializedName("turn_off_show_news_android")
    public boolean isShowNews;
}
