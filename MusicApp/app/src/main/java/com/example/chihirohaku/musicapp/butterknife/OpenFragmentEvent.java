package com.example.chihirohaku.musicapp.butterknife;

import android.support.v4.app.Fragment;

/**
 * Created by User on 1/10/2017.
 */

public class OpenFragmentEvent {
    Fragment fragment;
    boolean addToBackstack;

    public OpenFragmentEvent(Fragment fragment, boolean addToBackstack) {
        this.fragment = fragment;
        this.addToBackstack = addToBackstack;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public boolean isAddToBackstack() {
        return addToBackstack;
    }

    public void setAddToBackstack(boolean addToBackstack) {
        this.addToBackstack = addToBackstack;
    }
}
