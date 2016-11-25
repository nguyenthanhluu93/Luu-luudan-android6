package com.nankai.designlayout.dialog;

import android.app.AlertDialog.Builder;
import android.support.v7.app.AlertDialog;

/**
 * Created by namIT on 11/7/2016.
 */

public class BaseDialog {
    private static Builder mBuilder;
    private static AlertDialog mDialog;

    public synchronized static AlertDialog getAlertDialog() {
        return mDialog;
    }

    public Builder getBuilder() {
        return mBuilder;
    }

    public static void Builder(Builder builder) {
        mBuilder = builder;
    }
}
