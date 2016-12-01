package com.gvn.pets.ui.activity;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gvn.pets.R;
import com.gvn.pets.base.model.ServerResponse;
import com.gvn.pets.base.view.root.BaseActivityDefaultCallBack;
import com.gvn.pets.presenter.LoginPresenter;
import com.gvn.pets.widget.FontButton;
import com.gvn.pets.widget.FontEditext;

import retrofit2.Response;

/**
 * Created by namIT on 11/30/2016.
 */

public class LoginActivity extends BaseActivityDefaultCallBack<LoginPresenter> implements View.OnClickListener {

    private static String TAG = LoginActivity.class.getSimpleName();
    private static final String ELEMENT_LOGIN = "login";
    private FontButton btnLogin;
    private FontButton btnCancel;
    private FontEditext edtUser;
    private FontEditext edtPass;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    public static void launch(AppCompatActivity activity, FontButton logo) {
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, logo, ELEMENT_LOGIN);
        Intent intent = new Intent(activity, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent, options.toBundle());
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
        btnLogin = bindView(R.id.activity_login_btn_login);
        btnCancel = bindView(R.id.activity_login_btn_cancel);
        edtUser = bindView(R.id.activity_login_edt_username);
        edtPass = bindView(R.id.activity_login_edt_pass);
        ViewCompat.setTransitionName(btnLogin, ELEMENT_LOGIN);
        btnLogin.callOnClick();
        btnCancel.setOnClickListener(this);

    }

    @Override
    protected void onViewReady() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        Runtime.getRuntime().gc();
    }

    @Override
    public <E extends ServerResponse> void showContent(Response<E> response) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_login_btn_cancel:
                finish();
                break;
        }
    }
}
