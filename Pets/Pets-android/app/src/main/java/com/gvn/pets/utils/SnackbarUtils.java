package com.gvn.pets.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by namIT on 11/21/2016.
 */

public class SnackbarUtils {

    public static void show(View view, String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG).show();
    }

    public static void showShort(View view, String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show();
    }
}