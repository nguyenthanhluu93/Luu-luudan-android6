package com.gvn.pets.presenter;

import com.gvn.pets.base.presenter.RxPresenter;
import com.gvn.pets.model.bean.GetApplicationInfoBean;
import com.gvn.pets.model.bean.GetUpdateInfoFlagBean;
import com.gvn.pets.model.bean.GetUserStatusBean;
import com.gvn.pets.model.bean.InstallCountBean;
import com.gvn.pets.model.bean.LoginBean;
import com.gvn.pets.model.http.RetrofitHelper;
import com.gvn.pets.model.http.api.GetApplicationInfoRequest;
import com.gvn.pets.model.http.api.GetUpdateInfoFlagRequest;
import com.gvn.pets.model.http.api.GetUserStatusRequest;
import com.gvn.pets.model.http.api.InstallCountRequest;
import com.gvn.pets.model.http.api.LoginRequest;
import com.gvn.pets.model.http.service.RequestService;
import com.gvn.pets.presenter.contract.SplashContract;

import javax.inject.Inject;

import retrofit2.Call;

/**
 * Created by namIT on 11/28/2016.
 */

public class SplashPresenter extends RxPresenter<SplashContract.View> implements SplashContract.Presenter {

    private RetrofitHelper mRetrofitHelper;

    @Inject
    public SplashPresenter(RetrofitHelper mRetrofitHelper) {
        this.mRetrofitHelper = mRetrofitHelper;
    }

    @Override
    public GetApplicationInfoBean getApplicationInfo() {
        GetApplicationInfoRequest infoRequest = new GetApplicationInfoRequest();
        RequestService request = mRetrofitHelper.restartRequestServer();
        Call<GetApplicationInfoBean> bodyCall = request.getInfoForApplication(infoRequest);
        bodyCall.enqueue(new OnRetrofitCallback<GetApplicationInfoBean>().onRetrofitCallback(view));
        return new GetApplicationInfoBean();
    }

    @Override
    public InstallCountBean sendInstallCount(InstallCountRequest installCountRequest) {
        RequestService request = mRetrofitHelper.restartRequestServer();
        Call<InstallCountBean> bodyCall = request.installApplication(installCountRequest);
        bodyCall.enqueue(new OnRetrofitCallback<GetApplicationInfoBean>().onRetrofitCallback(view));
        return new InstallCountBean();
    }

    @Override
    public GetUpdateInfoFlagBean updateInfoFlagRequest(GetUpdateInfoFlagRequest updateInfoFlagRequest) {
        RequestService request = mRetrofitHelper.restartRequestServer();
        Call<GetUpdateInfoFlagBean> bodyCall = request.updateInfoFlagRequest(updateInfoFlagRequest);
        bodyCall.enqueue(new OnRetrofitCallback<GetApplicationInfoBean>().onRetrofitCallback(view));
        return new GetUpdateInfoFlagBean();
    }

    @Override
    public GetUserStatusBean getUserStatusRequest(GetUserStatusRequest userStatusRequest) {
        RequestService request = mRetrofitHelper.restartRequestServer();
        Call<GetUserStatusBean> bodyCall = request.getUserStatus(userStatusRequest);
        bodyCall.enqueue(new OnRetrofitCallback<GetUserStatusBean>().onRetrofitCallback(view));
        return new GetUserStatusBean();
    }

    @Override
    public LoginBean onResponseLogin(LoginRequest loginRequest) {
        RequestService request = mRetrofitHelper.restartRequestServer();
        Call<LoginBean> bodyCall = request.login(loginRequest);
        bodyCall.enqueue(new OnRetrofitCallback<LoginBean>().onRetrofitCallback(view));
        return new LoginBean();
    }
}
