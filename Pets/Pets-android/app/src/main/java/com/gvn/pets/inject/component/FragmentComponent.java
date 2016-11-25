package com.gvn.pets.inject.component;

import android.app.Activity;

import com.gvn.pets.inject.FragmentScope;
import com.gvn.pets.inject.module.FragmentModule;
import com.gvn.pets.ui.fragment.TestFragment;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
    Activity getActivity();
    // inject fragment
    void inject(TestFragment testFragment);

}
