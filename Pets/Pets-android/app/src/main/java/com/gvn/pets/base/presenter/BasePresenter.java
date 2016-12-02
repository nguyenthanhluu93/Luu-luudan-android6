package com.gvn.pets.base.presenter;

import android.content.Context;

import com.gvn.pets.app.BaseView;
import com.gvn.pets.model.bean.LoginBean;

/**
 * Created by namIT on 11/21/2016.
 */

public interface BasePresenter<T extends BaseView>{

    void attachView(T view);

    void detachView();

    //SERVER_INVALID_TOKEN
    LoginBean onAutoLogin(Context context);
}