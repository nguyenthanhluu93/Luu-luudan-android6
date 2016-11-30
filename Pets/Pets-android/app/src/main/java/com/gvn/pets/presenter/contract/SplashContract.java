package com.gvn.pets.presenter.contract;

import com.gvn.pets.base.presenter.BasePresenter;
import com.gvn.pets.base.presenter.BasePresenterCallback;
import com.gvn.pets.model.bean.GetApplicationInfoBean;
import com.gvn.pets.model.bean.GetUpdateInfoFlagBean;
import com.gvn.pets.model.bean.GetUserStatusBean;
import com.gvn.pets.model.bean.InstallCountBean;
import com.gvn.pets.model.bean.LoginBean;
import com.gvn.pets.model.http.RetrofitCallback;
import com.gvn.pets.model.http.api.GetUpdateInfoFlagRequest;
import com.gvn.pets.model.http.api.GetUserStatusRequest;
import com.gvn.pets.model.http.api.InstallCountRequest;
import com.gvn.pets.model.http.api.LoginRequest;

/**
 * Created by namIT on 11/28/2016.
 */

public interface SplashContract extends BasePresenterCallback {

    interface View extends RetrofitCallback.DefaultViewCallBack {
    }

    interface Presenter extends BasePresenter<SplashContract.View> {

        GetApplicationInfoBean getApplicationInfo();

        InstallCountBean sendInstallCount(InstallCountRequest installCountRequest);

        GetUpdateInfoFlagBean updateInfoFlagRequest(GetUpdateInfoFlagRequest updateInfoFlagRequest);

        GetUserStatusBean getUserStatusRequest(GetUserStatusRequest userStatusRequest);

        LoginBean onResponseLogin(LoginRequest loginRequest);
    }
}

