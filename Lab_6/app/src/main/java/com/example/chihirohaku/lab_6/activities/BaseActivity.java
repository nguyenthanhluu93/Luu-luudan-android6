package com.example.chihirohaku.lab_6.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Chihirohaku on 12/18/2016.
 */

public class BaseActivity extends AppCompatActivity {

    public void changeFragment(int resId, Fragment detailFragment){ // Fragment v4.app
        // get fragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Start replacing

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //
        fragmentTransaction.replace(resId, detailFragment);

        fragmentTransaction.commit();
    }

}
