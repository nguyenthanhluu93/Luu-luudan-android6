package com.luunt.sqlite_dictionary;

import android.app.Application;

import com.luunt.sqlite_dictionary.managers.DbHelper;

/**
 * Created by Chihirohaku on 11/19/2016.
 */
public class DictionaryApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DbHelper.init(this);
    }
}
