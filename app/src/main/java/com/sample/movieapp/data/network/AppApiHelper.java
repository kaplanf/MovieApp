package com.sample.movieapp.data.network;


import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sample.movieapp.data.network.model.MovieResponse;
import io.reactivex.Observable;
import io.realm.RealmObject;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppApiHelper implements ApiHelper {

  private ApiHeader mApiHeader;

  @Inject
  public AppApiHelper(ApiHeader apiHeader) {
    mApiHeader = apiHeader;
  }

  @Override
  public ApiHeader getApiHeader() {
    return mApiHeader;
  }

  @Override
  public Observable<MovieResponse> getPopular(String apikey) {
    Retrofit retrofit = new Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(ApiEndPoint.BASE_URL)
        .build();

    ApiHelper apiHelper = retrofit.create(ApiHelper.class);

    return apiHelper.getPopular(apikey);
  }

  @Override
  public Observable<MovieResponse> getTopRated(String apikey) {
    Retrofit retrofit = new Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(ApiEndPoint.BASE_URL)
        .build();

    ApiHelper apiHelper = retrofit.create(ApiHelper.class);

    return apiHelper.getTopRated(apikey);
  }

  @Override
  public Observable<MovieResponse> getUpcoming(String apikey) {
    Retrofit retrofit = new Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(ApiEndPoint.BASE_URL)
        .build();

    ApiHelper apiHelper = retrofit.create(ApiHelper.class);

    return apiHelper.getUpcoming(apikey);
  }


}

