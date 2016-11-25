package com.gvn.pets.inject.module;


import com.gvn.pets.app.AppController;
import com.gvn.pets.inject.ContextLife;
import com.gvn.pets.model.http.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by codeest on 16/8/7.
 */

@Module
public class AppModule {
    private final AppController application;

    public AppModule(AppController application) {
        this.application = application;
    }

    @Provides
    @Singleton
    @ContextLife("Application")
    AppController provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    RetrofitHelper provideRetrofitHelper() {
        return new RetrofitHelper();
    }

//    @Provides
//    @Singleton
//    RealmHelper provideRealmHelper() {
//        return new RealmHelper(application);
//    }
}
