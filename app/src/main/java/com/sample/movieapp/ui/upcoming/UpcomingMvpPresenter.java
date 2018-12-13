package com.sample.movieapp.ui.upcoming;

import com.sample.movieapp.ui.base.MvpPresenter;

public interface UpcomingMvpPresenter<V extends UpcomingMvpView> extends MvpPresenter<V> {
  void getUpcoming();
}
