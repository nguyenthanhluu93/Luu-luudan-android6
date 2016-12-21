package com.example.chihirohaku.lab_6.eventbus;

import android.support.v4.app.Fragment;

/**
 * Created by Chihirohaku on 12/20/2016.
 */

public class OpenFragmentEvent {
    private Fragment fragment;
    private boolean addToBackstack;

    public OpenFragmentEvent(Fragment fragment, boolean addToBackstack) {
        this.fragment = fragment;
        this.addToBackstack = addToBackstack;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public boolean isAddToBackstack() {
        return addToBackstack;
    }
}
