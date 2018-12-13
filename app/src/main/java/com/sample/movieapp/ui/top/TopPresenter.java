package com.sample.movieapp.ui.top;

import com.sample.movieapp.data.DataManager;
import com.sample.movieapp.data.network.model.MovieResponse;
import com.sample.movieapp.ui.base.BasePresenter;
import com.sample.movieapp.util.AppConstants;
import com.sample.movieapp.util.rx.SchedulerProvider;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;

public class TopPresenter<V extends TopMvpView> extends BasePresenter<V> implements
    TopMvpPresenter<V> {

  @Inject
  public TopPresenter(DataManager dataManager,
      SchedulerProvider schedulerProvider,
      CompositeDisposable compositeDisposable) {
    super(dataManager, schedulerProvider, compositeDisposable);
  }

  @Override
  public void getTopRated() {
    getMvpView().showLoading();
    getCompositeDisposable().add(
        getDataManager().getTopRated(AppConstants.API_KEY).subscribeOn(getSchedulerProvider().io())
            .observeOn(getSchedulerProvider().ui()).subscribe(
            new Consumer<MovieResponse>() {
              @Override
              public void accept(MovieResponse movieResponse) throws Exception {
                movieResponse.setCategory(0);
                getRealm().executeTransactionAsync(realm -> {
                  realm.copyToRealmOrUpdate(movieResponse);
                });
                getMvpView().hideLoading();
                Observable.fromIterable(movieResponse.getResults()).map(movieObject -> movieObject)
                    .toList()
                    .subscribe((movieObjects, throwable) -> getMvpView().loadMovies(movieObjects));
              }
            }, new Consumer<Throwable>() {
              @Override
              public void accept(Throwable throwable) throws Exception {
                getMvpView().hideLoading();
              }
            }));
  }
}
