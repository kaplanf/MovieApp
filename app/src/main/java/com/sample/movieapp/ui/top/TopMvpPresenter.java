package com.sample.movieapp.ui.top;

import com.sample.movieapp.ui.base.MvpPresenter;

public interface TopMvpPresenter<V extends TopMvpView> extends MvpPresenter<V> {
  void getTopRated();
}
