package com.gvn.pets.presenter;

import com.gvn.pets.base.presenter.RxPresenter;
import com.gvn.pets.model.http.RetrofitHelper;
import com.gvn.pets.presenter.contract.LoginContract;

import javax.inject.Inject;

/**
 * Created by namIT on 11/30/2016.
 */

public class LoginPresenter extends RxPresenter<LoginContract.View> {
    private RetrofitHelper mRetrofitHelper;

    @Inject
    public LoginPresenter(RetrofitHelper mRetrofitHelper) {
        this.mRetrofitHelper = mRetrofitHelper;
    }

}
