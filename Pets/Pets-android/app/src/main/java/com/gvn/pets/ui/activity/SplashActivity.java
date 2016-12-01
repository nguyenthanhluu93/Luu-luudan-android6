package com.gvn.pets.ui.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.gvn.pets.R;
import com.gvn.pets.base.model.ServerResponse;
import com.gvn.pets.base.view.root.BaseActivityDefaultCallBack;
import com.gvn.pets.model.bean.AuthenticationBean;
import com.gvn.pets.model.bean.GetApplicationInfoBean;
import com.gvn.pets.model.bean.GetUpdateInfoFlagBean;
import com.gvn.pets.model.bean.InstallCountBean;
import com.gvn.pets.model.bean.LoginBean;
import com.gvn.pets.model.http.api.GetUpdateInfoFlagRequest;
import com.gvn.pets.model.http.api.GetUserStatusRequest;
import com.gvn.pets.model.http.api.InstallCountRequest;
import com.gvn.pets.presenter.SplashPresenter;
import com.gvn.pets.utils.LogUtils;
import com.gvn.pets.utils.Utils;
import com.gvn.pets.utils.prefers.AppPreference;
import com.gvn.pets.utils.prefers.GoogleReviewPreference;
import com.gvn.pets.utils.prefers.UserPreference;
import com.nankai.designlayout.dialog.DialogMaterial;

import retrofit2.Response;

/**
 * Created by namIT on 11/28/2016.
 */

public class SplashActivity extends BaseActivityDefaultCallBack<SplashPresenter> {

    private static String TAG = SplashActivity.class.getSimpleName();
    private ImageView logo;
    private Handler handler = new Handler();
    private Runnable runnableSignUp = new Runnable() {
        @Override
        public void run() {
            SignUpActivity.launch(SplashActivity.this, logo);
        }
    };

    private Runnable runnableMain = new Runnable() {
        @Override
        public void run() {
            startMainScreen();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initInject() {
        //Register fragment
        getActivityComponent().inject(this);
        logo = bindView(R.id.activity_splash_logo);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            if (hasFocus) {
                getWindow().getDecorView()
                        .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
            }
        }
    }

    @Override
    protected void onViewReady() {
        presenter.getApplicationInfo();


    }

    @Override
    protected void onResume() {
        super.onResume();
        Runtime.getRuntime().gc();
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacks(runnableMain);
        handler.removeCallbacks(runnableSignUp);
        super.onDestroy();
    }

    private void handleApplicationInfoBean(GetApplicationInfoBean response) {
        int code = response.getCode();
        GoogleReviewPreference preference = GoogleReviewPreference.getInstance();
        if (code == ServerResponse.SERVER_SUCCESS) {
            preference.saveTurnOffVersion(response.switchBrowserVersion);
            preference.saveEnableGetFreePoint(response.isGetFreePoint);
            preference.saveEnableLoginByAnotherSystem(response
                    .isLoginByAnotherSystem);
            preference.saveEnableBrowser(response.isSwitchBrowser);
            preference.saveIsTurnOffUserInfo(response.isTurnOffUserInfo);
        } else {
            preference.saveTurnOffVersion("");
            preference.saveEnableGetFreePoint(false);
            preference.saveEnableLoginByAnotherSystem(false);
            preference.saveEnableBrowser(false);
            preference.saveIsTurnOffUserInfo(false);
        }

        // Check application first install
        AppPreference preferences = AppPreference.getInstance();

        if (preferences.isInstall()) {
            checkInfoUpdated();
        } else {
            // Request to count and check user info after count
            String android_id = Settings.Secure.getString(getContentResolver(),
                    Settings.Secure.ANDROID_ID);
            InstallCountRequest countRequest = new InstallCountRequest(1, android_id);
            presenter.sendInstallCount(countRequest);
        }
    }

    private void checkInfoUpdated() {
        UserPreference userPreference = UserPreference.getInstance();
        String token = userPreference.getToken();

        int type = Utils.isNeededGetUserStatus();

        if (type != GetUserStatusRequest.TYPE_NONE) {
            requestGetUserStatus(type);
        } else if (TextUtils.isEmpty(token)) {
            autoLogin();
        } else {
            // Register Linphone service
//            LinphoneService.startLogin(getApplicationContext());

            // Request user information updated
            GetUpdateInfoFlagRequest request = new GetUpdateInfoFlagRequest(
                    token);
            presenter.updateInfoFlagRequest(request);
        }
    }

    public void requestGetUserStatus(int type) {
        LogUtils.d(TAG, "requestGetUserStatus - " + type);
        UserPreference prefers = UserPreference.getInstance();
        String data = null;
        switch (type) {
            case GetUserStatusRequest.TYPE_EMAIL:
                data = prefers.getRegEmail();
                break;
            case GetUserStatusRequest.TYPE_FACEBOOK:
                data = prefers.getFacebookId();
                break;
            default:
                break;
        }

        if (data == null)
            return;

        GetUserStatusRequest request = new GetUserStatusRequest(type, data);
        presenter.getUserStatusRequest(request);
    }

    private void onResponseUpdateInfoFlag(GetUpdateInfoFlagBean response) {
        int code = response.getCode();
        switch (code) {
            case ServerResponse.SERVER_SUCCESS:
                UserPreference pre = UserPreference.getInstance();
                pre.saveAgeVerification(response.verificationFlag);
                pre.saveFinishRegister(response.finishRegisterFlag);
            case ServerResponse.SERVER_ACCESS_DENIED:
            case ServerResponse.SERVER_INVALID_TOKEN:
                UserPreference prefers = UserPreference.getInstance();
                if (!TextUtils.isEmpty(prefers.getToken())) {
                    startMainScreen();
                } else {
                    if (null != autoLogin())
                        presenter.onResponseLogin(autoLogin());
                }
                break;
            default:
                final DialogMaterial.Builder dialogError = new DialogMaterial.Builder(this)
                        .setIcon(R.mipmap.ic_launcher)
                        .withDialogAnimation(true)
                        .setTitle("Error!")
                        .setDescription("Error")
                        .setHeaderColor(R.color.colorAccent)
                        .onPositive("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                LogUtils.d(TAG, "Dialog dismiss");
                                dialog.dismiss();
                            }
                        });
                dialogError.show();
                break;
        }
    }

    private void onResponseLogin(LoginBean loginBean) {
        int code = loginBean.getCode();
        switch (code) {
            case ServerResponse.SERVER_SUCCESS:
                // Save info when login success
                AuthenticationBean authenData = loginBean.authenData;

                UserPreference userPreferences = UserPreference.getInstance();
                userPreferences.saveSuccessLoginData(authenData, true);

                AppPreference preferences = AppPreference.getInstance();
                preferences.saveTimeSetting(authenData);
                preferences.savePointSetting(authenData);

                // Login time
                preferences.saveTimeRelogin(System.currentTimeMillis());
                GoogleReviewPreference googleReviewPreference = new GoogleReviewPreference();
                googleReviewPreference.saveTurnOffVersion(loginBean
                        .switchBrowserVersion);
                googleReviewPreference.saveEnableGetFreePoint(loginBean
                        .isEnableGetFreePoint);
                googleReviewPreference.saveIsTurnOffUserInfo(loginBean.isTurnOffUserInfo);

                handler.postDelayed(runnableMain, 400);
                break;
            default:
                handler.postDelayed(runnableSignUp, 400);
        }
    }

    private void onResponseInstallCount(InstallCountBean response) {
        int code = response.getCode();
        switch (code) {
            case ServerResponse.SERVER_SUCCESS:
                AppPreference preferences = AppPreference.getInstance();
                preferences.saveIsInstalled();
            default:
                checkInfoUpdated();
                break;
        }
    }

    @Override
    public <E extends ServerResponse> void showContent(Response<E> response) {
        if (response.body() instanceof GetApplicationInfoBean) {
            handleApplicationInfoBean((GetApplicationInfoBean) response.body());

        } else if (response.body() instanceof GetUpdateInfoFlagBean) {
            onResponseUpdateInfoFlag((GetUpdateInfoFlagBean) response.body());

        } else if (response.body() instanceof LoginBean) {
            onResponseLogin((LoginBean) response.body());

        } else if (response.body() instanceof InstallCountBean) {
            onResponseInstallCount((InstallCountBean) response.body());
        }
    }
}
