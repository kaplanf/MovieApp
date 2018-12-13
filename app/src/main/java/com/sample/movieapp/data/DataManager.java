package com.sample.movieapp.data;


import com.sample.movieapp.data.network.ApiHelper;
import com.sample.movieapp.data.prefs.PreferencesHelper;

public interface DataManager extends PreferencesHelper, ApiHelper {

    void updateApiHeader(String accessToken);
}
