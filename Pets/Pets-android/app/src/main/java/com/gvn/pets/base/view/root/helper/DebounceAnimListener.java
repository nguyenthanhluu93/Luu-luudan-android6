package com.gvn.pets.base.view.root.helper;

import android.view.animation.Animation;

import com.gvn.pets.base.view.root.SupportFragment;

/**
 * Transition animation listener: mainly to monitor the admission animation
 * Created by namIT on 11/21/2016.
 */
public class DebounceAnimListener implements Animation.AnimationListener {
    private SupportFragment fragment;

    public DebounceAnimListener(SupportFragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public void onAnimationStart(Animation animation) {
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        fragment.notifyEnterAnimEnd();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
