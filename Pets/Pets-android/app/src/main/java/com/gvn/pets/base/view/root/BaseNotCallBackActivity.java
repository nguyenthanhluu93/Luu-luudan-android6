package com.gvn.pets.base.view.root;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.view.View;

import com.gvn.pets.R;
import com.gvn.pets.utils.LogUtils;

/**
 * Created by namIT on 11/18/2016.
 */

public abstract class BaseNotCallBackActivity extends SupportActivity {

    private static String TAG = BaseNotCallBackActivity.class.getSimpleName();
    protected Activity context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            );
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(Color.TRANSPARENT);
                getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        }
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        LogUtils.d(TAG, "onCreate");
        context = this;
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
     * View Cài đặt thành công sẽ được sử lý ở phương thức này
     */
    protected abstract void onViewReady();
}
