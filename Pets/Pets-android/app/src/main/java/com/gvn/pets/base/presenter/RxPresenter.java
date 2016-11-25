package com.gvn.pets.base.presenter;

import com.gvn.pets.app.BaseView;
import com.gvn.pets.base.model.ServerResponse;
import com.gvn.pets.model.http.RetrofitCallback;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by namIT on 11/22/2016.
 */

public class RxPresenter<T extends BaseView> implements BasePresenter<T> {

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

}