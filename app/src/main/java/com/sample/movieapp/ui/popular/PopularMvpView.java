package com.sample.movieapp.ui.popular;

import com.sample.movieapp.data.network.model.MovieObject;
import com.sample.movieapp.ui.base.MvpView;
import java.util.List;

public interface PopularMvpView extends MvpView {
  void loadMovies(List<MovieObject> movieObjects);
}
