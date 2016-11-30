package com.gvn.pets.base;

import android.content.Context;
import android.content.SharedPreferences;

import com.gvn.pets.app.AppController;

/**
 * Created by namIT on 11/28/2016.
 */

public abstract class BasePrefers {
    protected Context mContext;

    public BasePrefers() {
        mContext = AppController.getInstance();
    }

    protected SharedPreferences getPreferences() {
        return mContext.getSharedPreferences(getFileNamePrefers(),
                Context.MODE_PRIVATE);
    }

    protected SharedPreferences.Editor getEditor() {
        return getPreferences().edit();
    }

    protected abstract String getFileNamePrefers();
}