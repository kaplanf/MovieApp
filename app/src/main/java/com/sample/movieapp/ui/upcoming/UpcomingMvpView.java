package com.sample.movieapp.ui.upcoming;

import com.sample.movieapp.data.network.model.MovieObject;
import com.sample.movieapp.ui.base.MvpView;
import java.util.List;

public interface UpcomingMvpView extends MvpView {
  void loadMovies(List<MovieObject> movieObjects);
}
