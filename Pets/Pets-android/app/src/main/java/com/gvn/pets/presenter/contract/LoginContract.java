package com.gvn.pets.presenter.contract;

import com.gvn.pets.base.presenter.BasePresenter;
import com.gvn.pets.base.presenter.BasePresenterCallback;
import com.gvn.pets.model.http.RetrofitCallback;

/**
 * Created by namIT on 11/30/2016.
 */

public interface LoginContract extends BasePresenterCallback {

    interface View extends RetrofitCallback.DefaultViewCallBack {
    }

    interface Presenter extends BasePresenter<SplashContract.View> {
    }
}
