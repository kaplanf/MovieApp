package com.sample.movieapp.ui.main;

import com.sample.movieapp.di.PerActivity;
import com.sample.movieapp.ui.base.MvpPresenter;

@PerActivity
public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {
}
