package com.gvn.pets.base.view.root;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;

import com.gvn.pets.R;
import com.gvn.pets.app.AppController;
import com.gvn.pets.app.BaseView;
import com.gvn.pets.base.presenter.BasePresenter;
import com.gvn.pets.inject.component.ActivityComponent;
import com.gvn.pets.inject.component.DaggerActivityComponent;
import com.gvn.pets.inject.module.ActivityModule;
import com.gvn.pets.model.http.api.LoginByEmailRequest;
import com.gvn.pets.model.http.api.LoginByFacebookRequest;
import com.gvn.pets.model.http.api.LoginRequest;
import com.gvn.pets.ui.activity.SignUpActivity;
import com.gvn.pets.ui.activity.SplashActivity;
import com.gvn.pets.utils.LogUtils;
import com.gvn.pets.utils.SystemUtils;
import com.gvn.pets.utils.TimeUtils;
import com.gvn.pets.utils.prefers.AppPreference;
import com.gvn.pets.utils.prefers.UserPreference;

import javax.inject.Inject;

/**
 * Created by namIT on 11/18/2016.
 */

public abstract class BaseActivity<T extends BasePresenter> extends SupportActivity implements BaseView {

    private static String TAG = BaseActivity.class.getSimpleName();
    @Inject
    protected T presenter;
    protected Activity context;

    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(AppController.getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            );
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(Color.TRANSPARENT);
                getWindow().setNavigationBarColor(getResources().getColor(R.color.navigation_bar_color));
            }
        }
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        LogUtils.d(TAG, "onCreate");
        context = this;
        initInject();
        if (presenter != null)
            presenter.attachView(this);
        AppController.getInstance().addActivity(this);
        onViewReady();
    }


    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.d(TAG, "onResume");
        Runtime.getRuntime().gc();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        LogUtils.d(TAG, "onPostResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.d(TAG, "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtils.d(TAG, "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.d(TAG, "onDestroy");
        if (presenter != null) presenter.detachView();
        AppController.getInstance().removeActivity(this);
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        LogUtils.d(TAG, "onAttachFragment: " + fragment.getClass().getSimpleName());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        LogUtils.d(TAG, "resultCode: " + resultCode + "\n" + "requestCode: " + requestCode);
    }

    @Override
    public void onBackPressedSupport() {
        super.onBackPressedSupport();
        LogUtils.d(TAG, "onBackPressedSupport");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        LogUtils.d(TAG, "onBackPressed");
    }

    public void startAuthenScreen() {
        LogUtils.d(TAG, "start Authen Screen");
        if (this instanceof SignUpActivity)
            return;
            startActivity(new Intent(this, SignUpActivity.class));
            finish();
    }

    public void startMainScreen() {
        LogUtils.d(TAG, "start Main Screen");
//        if (this instanceof MainActivity)
//            return;
//        // Send active action to ApptizerF
//        UserPreference userPreferences = UserPreference.getInstance();
//            startActivity(new Intent(this, MainActivity.class));
//            finish();
    }

    /**
     * Replacement findViewById
     *
     * @param id id res
     * @return
     */
    protected <T extends View> T bindView(@IdRes int id) {
        return (T) findViewById(id);
    }

    /**
     * @return return LayoutId của fragment
     */
    protected abstract int getLayoutId();

    /**
     * Ở đây sẽ gọi phương thức này để đăng ký Callback
     * getActivityComponent().inject(this)\
     * và khởi tạo các View ở đây
     */
    protected abstract void initInject();

    /**
     * View Cài đặt thành công sẽ được sử lý ở phương thức này
     */
    protected abstract void onViewReady();

    //CallBack
    @Override
    public void showError(String msg) {
        //TODO callback
        LogUtils.i(TAG, msg);
    }
}
