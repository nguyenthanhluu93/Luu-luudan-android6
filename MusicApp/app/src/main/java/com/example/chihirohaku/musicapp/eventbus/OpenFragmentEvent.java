package com.example.chihirohaku.musicapp.eventbus;

import android.support.v4.app.Fragment;

import com.example.chihirohaku.musicapp.models.Subgenres;
import com.example.chihirohaku.musicapp.models.SubgenresRealm;

/**
 * Created by User on 1/10/2017.
 */

public class OpenFragmentEvent {
    Fragment fragment;
    boolean addToBackstack;
    boolean isShowToolbar;

    public OpenFragmentEvent(Fragment fragment,boolean addToBackstack, boolean isShowToolbar) {
        this.fragment = fragment;
        this.addToBackstack = addToBackstack;
        this.isShowToolbar = isShowToolbar;
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

    public boolean isShowToolbar() {
        return isShowToolbar;
    }

    public void setShowToolbar(boolean showToolbar) {
        isShowToolbar = showToolbar;
    }

}
