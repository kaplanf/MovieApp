package com.sample.movieapp.ui.popular;

import com.sample.movieapp.ui.base.MvpPresenter;

public interface PopularMvpPresenter<V extends PopularMvpView> extends MvpPresenter<V> {
  void getPopular();
}
