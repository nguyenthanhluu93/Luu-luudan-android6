package com.luunt.listviewintro.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Chihirohaku on 11/8/2016.
 */
public class BaseActivity extends AppCompatActivity {

    public void changeFrgment(int resId, Fragment fragment, boolean addToBackStack) {
        //3: get FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();
        //4: start replacing
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(resId, fragment);
        //6: (optional)
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }

        //7:
        fragmentTransaction.commit();
    }
}
