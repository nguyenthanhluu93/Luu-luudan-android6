package com.gvn.pets.utils.prefers;

import android.text.TextUtils;

import com.gvn.pets.app.AppController;
import com.gvn.pets.base.BasePrefers;
import com.gvn.pets.utils.Utils;

/**
 * Created by namIT on 11/28/2016.
 */

public class GoogleReviewPreference extends BasePrefers{

    public static GoogleReviewPreference getInstance() {
        GoogleReviewPreference mPreferences = new GoogleReviewPreference();
        return mPreferences;
    }

    public GoogleReviewPreference() {
        super();
    }

    @Override
    protected String getFileNamePrefers() {
        return "google_review";
    }

    private final String TURN_OFF_VERSION = "turn.off.version";

    public void saveTurnOffVersion(String version) {
        getEditor().putString(TURN_OFF_VERSION, String.valueOf(version))
                .commit();
    }

    /**
     * @return Return true if current version greater than or same server
     */
    public boolean isBelowTurnOffVersion() {
        String turnOffVersion = getPreferences()
                .getString(TURN_OFF_VERSION, "");
        if (TextUtils.isEmpty(turnOffVersion)) {
            return true;
        }

        String currentVersion = Utils.getAppVersionName(AppController.getInstance());
        if (TextUtils.isEmpty(currentVersion)) {
            return true;
        }

        String[] turnOffElements = turnOffVersion.split("\\.");
        String[] currentElements = currentVersion.split("\\.");

        int size = currentElements.length;
        boolean isSizeTurnOffMoreThanCurrent = true;
        if (size >= turnOffElements.length) {
            size = turnOffElements.length;
            isSizeTurnOffMoreThanCurrent = false;
        }

        for (int i = 0; i < size; i++) {
            int turnOffValue = 0;
            int currentValue = 0;

            try {
                turnOffValue = Integer.parseInt(turnOffElements[i]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return false;
            }

            try {
                currentValue = Integer.parseInt(currentElements[i]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return true;
            }

            if (currentValue < turnOffValue) {
                return true;
            } else if (currentValue > turnOffValue) {
                return false;
            }
        }

        return isSizeTurnOffMoreThanCurrent;
    }

    private final String IS_ENABLE_GET_FREE_POINT = "is.enable.get.free.point";

    public void saveEnableGetFreePoint(boolean isTurnOn) {
        getEditor().putBoolean(IS_ENABLE_GET_FREE_POINT, isTurnOn).commit();
    }

    public boolean isEnableGetFreePoint() {
        return getPreferences().getBoolean(IS_ENABLE_GET_FREE_POINT, false)
                || isBelowTurnOffVersion();
    }

    private final String IS_TURN_OFF_USER_INFO = "is.turn.off.user.info";

    public void saveIsTurnOffUserInfo(boolean isTurnOn) {
        getEditor().putBoolean(IS_TURN_OFF_USER_INFO, isTurnOn).commit();
    }

    public boolean isTurnOffUserInfo() {
        return getPreferences().getBoolean(IS_TURN_OFF_USER_INFO, false)
                || isBelowTurnOffVersion();
    }

    private final String IS_ENABLE_LOGIN_BY_MOCOM = "is.enable.login.by.another.system";

    public void saveEnableLoginByAnotherSystem(boolean isTurnOn) {
        getEditor().putBoolean(IS_ENABLE_LOGIN_BY_MOCOM, isTurnOn).commit();
    }

    public boolean isEnableLoginByAnotherSystem() {
        return getPreferences().getBoolean(IS_ENABLE_LOGIN_BY_MOCOM, false)
                || isBelowTurnOffVersion();
    }

    private final String IS_ENABLE_BROWSER = "is.enable.browser";

    public void saveEnableBrowser(boolean isTurnOn) {
        getEditor().putBoolean(IS_ENABLE_BROWSER, isTurnOn).commit();
    }

    public boolean isEnableBrowser() {
        return getPreferences().getBoolean(IS_ENABLE_BROWSER, false)
                || isBelowTurnOffVersion();
    }

    public void clearAll() {
        getEditor().clear().commit();
    }
}