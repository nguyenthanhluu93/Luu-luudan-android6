package com.gvn.pets.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.View;

import com.gvn.pets.app.AppController;
import com.gvn.pets.app.Constants;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by namIT on 11/22/2016.
 */

public class SystemUtils {
    public static String TAG = SystemUtils.class.getSimpleName();

    /**
     * Check if WIFI is connected
     */
    public static boolean isWifiConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) AppController.getInstance().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiInfo = connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        return wifiInfo != null;
    }

    /**
     * Check if the phone network (4G / 3G / 2G) is connected
     */
    public static boolean isMobileNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) AppController.getInstance().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mobileNetworkInfo = connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        return mobileNetworkInfo != null;
    }

    /**
     * Check if there is an available network
     */
    public static boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) AppController.getInstance().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null;
    }

    /**
     * Save the text to the clipboard
     *
     * @param context
     * @param text
     */
    public static void copyToClipBoard(Context context, String text) {
        ClipData clipData = ClipData.newPlainText("url", text);
        ClipboardManager manager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        manager.setPrimaryClip(clipData);
//        ToastUtil.shortShow("Copied to the clipboard");
    }

    /**
     * Save the image to the local
     *
     * @param context
     * @param url
     * @param bitmap
     */
    public static Uri saveBitmapToFile(Context context, String url, Bitmap bitmap, View container, boolean isShare) {
        String fileName = url.substring(url.lastIndexOf("/"), url.lastIndexOf(".")) + ".png";
        File fileDir = new File(Constants.PATH_DATA);
        if (!fileDir.exists()) {
            fileDir.mkdir();
        }
        File imageFile = new File(fileDir, fileName);
        Uri uri = Uri.fromFile(imageFile);
        if (isShare && imageFile.exists()) {
            return uri;
        }
        try {
            FileOutputStream fos = new FileOutputStream(imageFile);
            boolean isCompress = bitmap.compress(Bitmap.CompressFormat.PNG, 90, fos);
            if (isCompress) {
                SnackbarUtils.showShort(container, "Save sister paper success");
            } else {
                SnackbarUtils.showShort(container, "Save the sister paper failed");
            }
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
            SnackbarUtils.showShort(container, "Save the sister paper failed");
        }
        try {
            MediaStore.Images.Media.insertImage(context.getContentResolver(), imageFile.getAbsolutePath(), fileName, null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri));
        return uri;
    }

    public static String getDeviceId() {
        Context context = AppController.getInstance();
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    public static String getAppVersionName(Context context) {
        String packageName = context.getPackageName();
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(
                    packageName, 0);
        } catch (Exception e) {
            LogUtils.e(TAG, String.valueOf(e.getMessage()));
        }
        String appVersion = "";
        if (packageInfo != null && packageInfo.versionName != null) {
            String version = packageInfo.versionName;
            if (version.contains(" ")) {
                appVersion = packageInfo.versionName.substring(0,
                        packageInfo.versionName.indexOf(" "));
            } else {
                appVersion = version;
            }
        }
        return appVersion;
    }

    public static String getDeviceName() {
        String name = android.os.Build.MODEL;
        LogUtils.d(TAG, "Device Name - " + name);
        return name;
    }

    public static String getAndroidOSVersion() {
        String release = Build.VERSION.RELEASE;
        int sdkVersion = Build.VERSION.SDK_INT;
        String name = "Android SDK: " + sdkVersion + " (" + release + ")";
        LogUtils.d(TAG, "Device Name - " + name);
        return name;
    }
}
