package com.sample.movieapp.ui.base;

import com.sample.movieapp.data.DataManager;
import com.sample.movieapp.util.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import io.realm.Realm;

import javax.inject.Inject;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

  private static final String TAG = "BasePresenter";

  private final DataManager mDataManager;
  private final SchedulerProvider mSchedulerProvider;
  private final CompositeDisposable mCompositeDisposable;

  private V mMvpView;

  public Realm getRealm() {
    return realm;
  }

  @Inject
  Realm realm;

  @Inject
  public BasePresenter(DataManager dataManager,
                       SchedulerProvider schedulerProvider,
                       CompositeDisposable compositeDisposable) {
    this.mDataManager = dataManager;
    this.mSchedulerProvider = schedulerProvider;
    this.mCompositeDisposable = compositeDisposable;
  }

  @Override
  public void onAttach(V mvpView) {
    mMvpView = mvpView;
  }

  @Override
  public void onDetach() {
    mCompositeDisposable.dispose();
    mMvpView = null;
  }

  public boolean isViewAttached() {
    return mMvpView != null;
  }

  public V getMvpView() {
    return mMvpView;
  }

  public DataManager getDataManager() {
    return mDataManager;
  }

  public SchedulerProvider getSchedulerProvider() {
    return mSchedulerProvider;
  }

  public CompositeDisposable getCompositeDisposable() {
    return mCompositeDisposable;
  }
}
