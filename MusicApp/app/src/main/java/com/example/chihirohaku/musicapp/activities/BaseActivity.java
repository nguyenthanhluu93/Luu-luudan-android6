package com.example.chihirohaku.musicapp.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Chihirohaku on 1/10/2017.
 */

public class BaseActivity extends AppCompatActivity {
    public void changeFragment(int resId, Fragment fragment, boolean addToBackstack) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(resId, fragment);
        if (addToBackstack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }
}
