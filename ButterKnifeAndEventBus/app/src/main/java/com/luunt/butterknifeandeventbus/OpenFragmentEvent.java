package com.luunt.butterknifeandeventbus;

import android.support.v4.app.Fragment;

/**
 * Created by Chihirohaku on 11/20/2016.
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
