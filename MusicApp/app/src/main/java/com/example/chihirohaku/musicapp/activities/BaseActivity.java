package com.example.chihirohaku.musicapp.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.chihirohaku.musicapp.models.Subgenres;

/**
 * Created by Chihirohaku on 1/10/2017.
 */

public class BaseActivity extends AppCompatActivity {
    public void changeFragment(int resId, Fragment fragment, boolean addToBackstack, boolean isShowToolbar) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(resId, fragment);
        if (addToBackstack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
        if (isShowToolbar) {
            this.getSupportActionBar().show();
        } else {
            this.getSupportActionBar().hide();
        }
    }
}
