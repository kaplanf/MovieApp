package com.sample.movieapp.ui.upcoming;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.sample.movieapp.R;
import com.sample.movieapp.data.network.model.MovieObject;
import com.sample.movieapp.data.network.model.MovieResponse;
import com.sample.movieapp.di.component.ActivityComponent;
import com.sample.movieapp.ui.base.BaseFragment;
import com.sample.movieapp.ui.main.MovieListAdapter;
import com.sample.movieapp.util.NetworkUtils;
import io.reactivex.Observable;
import io.realm.RealmList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class UpcomingFragment extends BaseFragment implements UpcomingMvpView,
    MovieListAdapter.Callback {

  public static final String TAG = "UpcomingFragment";

  @Inject
  UpcomingMvpPresenter<UpcomingMvpView> mPresenter;

  @Inject
  LinearLayoutManager mLayoutManager;

  @Inject
  MovieListAdapter adapter;

  @BindView(R.id.movie_recycler_view)
  RecyclerView movieRecyclerview;

  private ArrayList<MovieObject> movies;

  public static UpcomingFragment newInstance() {
    Bundle args = new Bundle();
    UpcomingFragment fragment = new UpcomingFragment();
    return fragment;
  }

  public void onAttach(Context context) {
    super.onAttach(context);
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_movie_list, container, false);
    ActivityComponent component = getActivityComponent();
    if (component != null) {
      component.inject(this);
      setUnBinder(ButterKnife.bind(this, view));
      mPresenter.onAttach(this);
    }
    return view;
  }

  @Override
  protected void setUp(View view) {
    if (NetworkUtils.isNetworkConnected(getActivity())) {
      mPresenter.getUpcoming();
    } else {
      loadFromDb();
    }
  }

  @Override
  public void loadMovies(List<MovieObject> movieObjects) {
    movies = (ArrayList<MovieObject>) movieObjects;
    adapter.setCallback(this);
    adapter.addItems(movies);
    mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    movieRecyclerview.setLayoutManager(mLayoutManager);
    movieRecyclerview.setAdapter(adapter);
  }

  private void loadFromDb() {
    Observable.fromIterable(
        getRealm().where(MovieResponse.class).equalTo("category", 1).findFirst().getResults())
        .map(movieObject -> movieObject)
        .toList()
        .subscribe((movieObjects, throwable) -> loadMovies(movieObjects));
  }
}
