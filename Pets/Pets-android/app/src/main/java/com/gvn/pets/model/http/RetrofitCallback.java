package com.gvn.pets.model.http;

import android.util.Log;

import com.gvn.pets.app.BaseView;
import com.gvn.pets.base.model.ServerResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by namIT on 11/25/2016.
 */

public abstract class RetrofitCallback<T extends ServerResponse> implements Callback<T> {

    public interface DefaultViewCallBack extends BaseView {
        void showError(int code);

        <E extends ServerResponse> void showContent(Response<E> response);
    }

    private static final String TAG = RetrofitCallback.class.getSimpleName();

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        int responseCode = response.code();
        Log.d(TAG, "onResponse: " + responseCode);
        if (responseCode == ServerResponse.CLIENT_SUCCESS) {
            if (response.body().getCode() == ServerResponse.SERVER_SUCCESS) {
                onResponseSuccess(call, response);
            } else {
                onResponseError(responseCode);
            }
        } else {
            onResponseError(responseCode);
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onResponseFailure(call, t);
    }

    public abstract void onResponseSuccess(Call<T> call, Response<T> response);

    public abstract void onResponseFailure(Call<T> call, Throwable t);

    public abstract void onResponseError(int code);
}
