package com.gvn.pets.base.view.root.helper;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.gvn.pets.R;
import com.gvn.pets.base.view.root.anim.FragmentAnimator;

/**
 * Created by namIT on 11/21/2016.
 */
public final class AnimatorHelper {
    private Animation noneAnim, noneAnimFixed;
    public Animation enterAnim, exitAnim, popEnterAnim, popExitAnim;

    private Context context;
    private FragmentAnimator fragmentAnimator;

    public AnimatorHelper(Context context, FragmentAnimator fragmentAnimator) {
        this.context = context;
        this.fragmentAnimator = fragmentAnimator;
        initEnterAnim();
        initExitAnim();
        initPopEnterAnim();
        initPopExitAnim();
    }

    public Animation getNoneAnim() {
        if (noneAnim == null) {
            noneAnim = AnimationUtils.loadAnimation(context, R.anim.no_anim);
        }
        return noneAnim;
    }

    public Animation getNoneAnimFixed() {
        if (noneAnimFixed == null) {
            noneAnimFixed = new Animation() {};
        }
        return noneAnimFixed;
    }

    private Animation initEnterAnim() {
        if (fragmentAnimator.getEnter() == 0) {
            enterAnim = AnimationUtils.loadAnimation(context, R.anim.no_anim);
        } else {
            enterAnim = AnimationUtils.loadAnimation(context, fragmentAnimator.getEnter());
        }
        return enterAnim;
    }

    private Animation initExitAnim() {
        if (fragmentAnimator.getExit() == 0) {
            exitAnim = AnimationUtils.loadAnimation(context, R.anim.no_anim);
        } else {
            exitAnim = AnimationUtils.loadAnimation(context, fragmentAnimator.getExit());
        }
        return exitAnim;
    }

    private Animation initPopEnterAnim() {
        if (fragmentAnimator.getPopEnter() == 0) {
            popEnterAnim = AnimationUtils.loadAnimation(context, R.anim.no_anim);
        } else {
            popEnterAnim = AnimationUtils.loadAnimation(context, fragmentAnimator.getPopEnter());
        }
        return popEnterAnim;
    }

    private Animation initPopExitAnim() {
        if (fragmentAnimator.getPopExit() == 0) {
            //Used to solve the start of a new Fragment, the transition process of animation on a Fragment page blank
            popExitAnim = AnimationUtils.loadAnimation(context, R.anim.pop_exit_no_anim);
        } else {
            popExitAnim = AnimationUtils.loadAnimation(context, fragmentAnimator.getPopExit());
        }
        return popExitAnim;
    }
}
