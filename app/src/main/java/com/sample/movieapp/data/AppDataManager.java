package com.sample.movieapp.data;


import android.content.Context;
import com.sample.movieapp.data.network.ApiHeader;
import com.sample.movieapp.data.network.ApiHelper;
import com.sample.movieapp.data.network.model.MovieResponse;
import com.sample.movieapp.data.prefs.PreferencesHelper;
import com.sample.movieapp.di.ApplicationContext;
import io.reactivex.Observable;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          PreferencesHelper preferencesHelper,
                          ApiHelper apiHelper) {
        mContext = context;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHelper.getApiHeader();
    }

    @Override
    public Observable<MovieResponse> getPopular(String apikey) {
        return mApiHelper.getPopular(apikey);
    }

    @Override
    public Observable<MovieResponse> getTopRated(String apikey) {
        return mApiHelper.getTopRated(apikey);
    }

    @Override
    public Observable<MovieResponse> getUpcoming(String apikey) {
        return mApiHelper.getUpcoming(apikey);
    }

    @Override
    public String getAccessToken() {
        return mPreferencesHelper.getAccessToken();
    }

    @Override
    public void setAccessToken(String accessToken) {
        mPreferencesHelper.setAccessToken(accessToken);
        mApiHelper.getApiHeader().getProtectedApiHeader().setAccessToken(accessToken);
    }

    @Override
    public void updateApiHeader(String accessToken) {
        mApiHelper.getApiHeader().getProtectedApiHeader().setAccessToken(accessToken);
    }
}
