package com.example.chihirohaku.lab_6.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Chihirohaku on 12/18/2016.
 */

public class BaseActivity extends AppCompatActivity {

    public void changeFragment(int resId, Fragment detailFragment, boolean addToBackstack, boolean removeFromBackstack) { // Fragment v4.app
        if (addToBackstack) {
            // get fragmentManager
            FragmentManager fragmentManager = getSupportFragmentManager();

            // Start replacing

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            //
            fragmentTransaction.replace(resId, detailFragment);

            fragmentTransaction.addToBackStack("");

            fragmentTransaction.commit();
        } else {
            FragmentManager fragmentManager = getSupportFragmentManager();

            // Start replacing

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            //
            fragmentTransaction.replace(resId, detailFragment);

            fragmentTransaction.commit();
        }
        if (removeFromBackstack){
            FragmentManager fragmentManager = getSupportFragmentManager();

            // Start replacing

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            //
            fragmentTransaction.remove(detailFragment);

            fragmentTransaction.commit();

            fragmentManager.popBackStack();
        }
    }

}
