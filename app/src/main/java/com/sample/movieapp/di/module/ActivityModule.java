package com.sample.movieapp.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import com.sample.movieapp.data.network.model.MovieObject;
import com.sample.movieapp.di.ActivityContext;
import com.sample.movieapp.di.PerActivity;
import com.sample.movieapp.ui.main.MainMvpPresenter;
import com.sample.movieapp.ui.main.MainMvpView;
import com.sample.movieapp.ui.main.MainPresenter;
import com.sample.movieapp.ui.main.MovieListAdapter;
import com.sample.movieapp.ui.popular.PopularMvpPresenter;
import com.sample.movieapp.ui.popular.PopularMvpView;
import com.sample.movieapp.ui.popular.PopularPresenter;
import com.sample.movieapp.ui.top.TopMvpPresenter;
import com.sample.movieapp.ui.top.TopMvpView;
import com.sample.movieapp.ui.top.TopPresenter;
import com.sample.movieapp.ui.upcoming.UpcomingMvpPresenter;
import com.sample.movieapp.ui.upcoming.UpcomingMvpView;
import com.sample.movieapp.ui.upcoming.UpcomingPresenter;
import com.sample.movieapp.util.rx.AppSchedulerProvider;
import com.sample.movieapp.util.rx.SchedulerProvider;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;


@Module
public class ActivityModule {

  private AppCompatActivity mActivity;

  public ActivityModule(AppCompatActivity activity) {
    this.mActivity = activity;
  }

  @Provides
  @ActivityContext
  Context provideContext() {
    return mActivity;
  }

  @Provides
  AppCompatActivity provideActivity() {
    return mActivity;
  }

  @Provides
  CompositeDisposable provideCompositeDisposable() {
    return new CompositeDisposable();
  }

  @Provides
  SchedulerProvider provideSchedulerProvider() {
    return new AppSchedulerProvider();
  }

  @Provides
  LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
    return new LinearLayoutManager(activity);
  }

  @Provides
  @PerActivity
  MainMvpPresenter<MainMvpView> provideMainPresenter(
      MainPresenter<MainMvpView> presenter) {
    return presenter;
  }

  @Provides
  TopMvpPresenter<TopMvpView> provideTopPresenter(
      TopPresenter<TopMvpView> presenter) {
    return presenter;
  }

  @Provides
  PopularMvpPresenter<PopularMvpView> providePopularPresenter(
      PopularPresenter<PopularMvpView> presenter) {
    return presenter;
  }

  @Provides
  UpcomingMvpPresenter<UpcomingMvpView> provideUpcomingPresenter(
      UpcomingPresenter<UpcomingMvpView> presenter) {
    return presenter;
  }

  @Provides
  MovieListAdapter provideMovieListAdapter(AppCompatActivity appCompatActivity) {
    return new MovieListAdapter(new ArrayList<MovieObject>());
  }
}
