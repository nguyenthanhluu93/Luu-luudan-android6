package com.gvn.pets.base.presenter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.gvn.pets.app.BaseView;
import com.gvn.pets.base.model.ServerResponse;
import com.gvn.pets.model.bean.LoginBean;
import com.gvn.pets.model.bean.UserLogin;
import com.gvn.pets.model.http.RetrofitCallback;
import com.gvn.pets.model.http.RetrofitHelper;
import com.gvn.pets.model.http.api.LoginByEmailRequest;
import com.gvn.pets.model.http.api.LoginByFacebookRequest;
import com.gvn.pets.model.http.service.RequestService;
import com.gvn.pets.ui.activity.SignUpActivity;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by namIT on 11/22/2016.
 */

public abstract class RxPresenter<T extends BaseView> implements BasePresenter<T> {
    protected RetrofitHelper mRetrofitHelper;

    protected T view;

    @Override
    public void attachView(T view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    //Default Response
    protected class OnRetrofitCallback<E extends ServerResponse> {
        public OnRetrofitCallback() {
        }

        public RetrofitCallback onRetrofitCallback(final RetrofitCallback.DefaultViewCallBack viewCallBack) {
            RetrofitCallback<E> moviesInfoMyRetrofitCallback = new RetrofitCallback<E>() {
                @Override
                public void onResponseSuccess(Call<E> call, Response<E> response) {
                    viewCallBack.showContent(response);
                }

                @Override
                public void onResponseFailure(Call<E> call, Throwable t) {
                    viewCallBack.showError(t.getMessage());
                }

                @Override
                public void onResponseError(int code) {
                    viewCallBack.showError(code);
                }
            };
            return moviesInfoMyRetrofitCallback;
        }
    }

    @Override
    public LoginBean onAutoLogin(Context context) {
        RequestService request = mRetrofitHelper.restartRequestServer();
        Call<LoginBean> bodyCall;
        UserLogin userLogin = UserLogin.onAutoLogin();
        if (!TextUtils.isEmpty(userLogin.getEmail())) {
            LoginByEmailRequest loginRequest = new LoginByEmailRequest(userLogin);
            bodyCall = request.loginEmail(loginRequest);
        } else if (!TextUtils.isEmpty(userLogin.getFacebookId())) {
            LoginByFacebookRequest loginRequest = new LoginByFacebookRequest(userLogin);
            bodyCall = request.loginFacebook(loginRequest);
        } else {
            Intent intent = new Intent(context, SignUpActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            context.startActivity(intent);
            return null;
        }
        bodyCall.enqueue(new OnRetrofitCallback<LoginBean>().onRetrofitCallback((RetrofitCallback.DefaultViewCallBack) view));
        return new LoginBean();
    }
}