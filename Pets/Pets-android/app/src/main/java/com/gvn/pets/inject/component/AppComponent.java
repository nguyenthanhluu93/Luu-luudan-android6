package com.gvn.pets.inject.component;


import com.gvn.pets.app.AppController;
import com.gvn.pets.inject.ContextLife;
import com.gvn.pets.inject.module.AppModule;
import com.gvn.pets.model.http.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    @ContextLife("Application")
    AppController getContext();

    RetrofitHelper retrofitHelper();

//    RealmHelper realmHelper();

}
