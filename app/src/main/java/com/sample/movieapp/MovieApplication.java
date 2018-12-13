package com.sample.movieapp;

import android.app.Application;
import com.sample.movieapp.data.DataManager;
import com.sample.movieapp.di.component.ApplicationComponent;
import com.sample.movieapp.di.component.DaggerApplicationComponent;
import com.sample.movieapp.di.module.ApplicationModule;
import io.realm.Realm;
import io.realm.RealmConfiguration;

import javax.inject.Inject;

public class MovieApplication extends Application {

    @Inject
    DataManager mDataManager;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);

        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().name("movieapp.realm").build();
        Realm.setDefaultConfiguration(config);
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
