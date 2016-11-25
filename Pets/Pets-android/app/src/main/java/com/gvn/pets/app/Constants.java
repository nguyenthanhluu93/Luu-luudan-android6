package com.gvn.pets.app;

import android.os.Environment;

import java.io.File;

/**
 * Created by namIT on 11/18/2016.
 */

public class Constants {

    //================= PATH ====================
    public static final String PATH_DATA = AppController.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

    public static final String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "codeest" + File.separator + "Pets";
}
