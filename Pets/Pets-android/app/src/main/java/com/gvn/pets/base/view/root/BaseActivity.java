package com.gvn.pets.base.view.root;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.view.View;

import com.gvn.pets.app.AppController;
import com.gvn.pets.app.BaseView;
import com.gvn.pets.utils.LogUtil;

/**
 * Created by namIT on 11/18/2016.
 */

public abstract class BaseActivity extends SupportActivity implements BaseView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.d("BaseActivity", "onCreate");
        AppController.getInstance().addActivity(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.d("BaseActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.d("BaseActivity", "onResume");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        LogUtil.d("BaseActivity", "onPostResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.d("BaseActivity", "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtil.d("BaseActivity", "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.d("BaseActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.d("BaseActivity", "onDestroy");
        AppController.getInstance().removeActivity(this);
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        LogUtil.d("BaseActivity", "onAttachFragment: " + fragment.getClass().getSimpleName());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        LogUtil.d("BaseActivity", "resultCode: " + resultCode + "\n" + "requestCode: " + requestCode);
    }

    @Override
    public void onBackPressedSupport() {
        super.onBackPressedSupport();
        LogUtil.d("BaseActivity", "onBackPressedSupport");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        LogUtil.d("BaseActivity", "onBackPressed");
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

    //CallBack
    @Override
    public void showError(String msg) {
        //TODO callback
        LogUtil.i("namIT", msg);
    }
}
