package com.gvn.pets.inject.component;

import android.app.Activity;

import com.gvn.pets.inject.ActivityScope;
import com.gvn.pets.inject.module.ActivityModule;
import com.gvn.pets.ui.activity.MainActivity;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

    // inject Activity
    void inject(MainActivity mainActivity);
}
