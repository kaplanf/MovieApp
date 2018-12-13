package com.sample.movieapp.di.module;

import android.app.Application;
import android.content.Context;
import com.sample.movieapp.data.AppDataManager;
import com.sample.movieapp.data.DataManager;
import com.sample.movieapp.data.network.ApiHeader;
import com.sample.movieapp.data.network.ApiHelper;
import com.sample.movieapp.data.network.AppApiHelper;
import com.sample.movieapp.data.prefs.AppPreferencesHelper;
import com.sample.movieapp.data.prefs.PreferencesHelper;
import com.sample.movieapp.di.ApplicationContext;
import com.sample.movieapp.di.DatabaseInfo;
import com.sample.movieapp.di.PreferenceInfo;
import com.sample.movieapp.util.AppConstants;
import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

import javax.inject.Singleton;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    Realm provideRealm() {
        return Realm.getDefaultInstance();
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                preferencesHelper.getAccessToken());
    }

}
