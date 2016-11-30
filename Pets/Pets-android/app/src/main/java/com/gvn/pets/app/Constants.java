package com.gvn.pets.app;

import android.os.Environment;

import java.io.File;

/**
 * Created by namIT on 11/18/2016.
 */

public class Constants {

    // Default finish register flag
    public static final int FINISH_REGISTER_YES = 1;
    public static final int FINISH_REGISTER_NO = 0;

    // Default dialog showed
    public static final boolean IS_SHOWED_FLAG = false;
    public static final boolean IS_NOT_SHOWED_FLAG = true;

    // Settings
    public static final int DISTANCE_UNIT_MILE = 0;
    public static final int DISTANCE_UNIT_KILOMETER = 1;

    //================= PATH ====================
    public static final String PATH_DATA = AppController.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

    public static final String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "codeest" + File.separator + "Pets";
}
