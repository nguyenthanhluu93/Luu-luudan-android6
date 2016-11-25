package com.gvn.pets.base.presenter;

import com.gvn.pets.app.BaseView;

/**
 * Created by namIT on 11/21/2016.
 */

public interface BasePresenter<T extends BaseView>{

    void attachView(T view);

    void detachView();
}