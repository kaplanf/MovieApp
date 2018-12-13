package com.sample.movieapp.di.component;

import android.app.Application;
import android.content.Context;

import com.sample.movieapp.MovieApplication;
import com.sample.movieapp.data.DataManager;
import com.sample.movieapp.di.ApplicationContext;
import com.sample.movieapp.di.module.ApplicationModule;
import dagger.Component;
import io.realm.Realm;

import javax.inject.Singleton;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MovieApplication app);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();

    Realm getRealm();
}