package com.sample.movieapp.ui.main;


import com.sample.movieapp.data.DataManager;
import com.sample.movieapp.data.network.model.MovieResponse;
import com.sample.movieapp.ui.base.BasePresenter;
import com.sample.movieapp.util.AppConstants;
import com.sample.movieapp.util.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

import javax.inject.Inject;
import java.util.concurrent.TimeUnit;

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V>
    implements MainMvpPresenter<V> {

  private static final String TAG = "MainPresenter";

  @Inject
  public MainPresenter(DataManager dataManager,
                       SchedulerProvider schedulerProvider,
                       CompositeDisposable compositeDisposable) {
    super(dataManager, schedulerProvider, compositeDisposable);
  }
}
