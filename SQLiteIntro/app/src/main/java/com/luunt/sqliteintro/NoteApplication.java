package com.luunt.sqliteintro;

import android.app.Application;
import android.util.Log;

import com.luunt.sqliteintro.managers.DbHelper;

/**
 * Created by Chihirohaku on 11/15/2016.
 */
public class NoteApplication extends Application {

    private static final String TAG = NoteApplication.class.toString();

    @Override
    public void onCreate() {
        Log.d(TAG, "OnCreate");
        super.onCreate();
        DbHelper.init(this);
    }
}
