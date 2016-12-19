package com.example.chihirohaku.lab_6.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.chihirohaku.lab_6.R;
import com.example.chihirohaku.lab_6.fragments.LoginFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = getSharedPreferences(LoginFragment.DATA, Context.MODE_PRIVATE);
        String token = sharedPreferences.getString(LoginFragment.TOKEN, "");
        Log.d("ôccoc", String.format("%s", token));
        LoginFragment loginFragment = new LoginFragment();
        changeFragment(R.id.fl_oc, loginFragment);
    }
}
