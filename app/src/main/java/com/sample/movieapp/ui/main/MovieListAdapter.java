package com.sample.movieapp.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.sample.movieapp.R;
import com.sample.movieapp.data.network.ApiEndPoint;
import com.sample.movieapp.data.network.model.MovieObject;
import com.sample.movieapp.ui.base.BaseViewHolder;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<BaseViewHolder> {


  private List<MovieObject> movies;
  private Callback mCallback;

  public static final int VIEW_TYPE_EMPTY = 0;
  public static final int VIEW_TYPE_NORMAL = 1;

  public MovieListAdapter(List<MovieObject> movies) {
    this.movies = movies;
  }

  public void setCallback(Callback callback) {
    mCallback = callback;
  }

  @Override
  public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    switch (viewType) {
      case VIEW_TYPE_NORMAL:
        return new MovieListAdapter.ViewHolder(
            LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.movie_item_view, parent, false));
      case VIEW_TYPE_EMPTY:
      default:
        return new MovieListAdapter.EmptyViewHolder(
            LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.movie_empty_view, parent, false));
    }
  }

  @Override
  public void onBindViewHolder(BaseViewHolder holder, int position) {
    holder.onBind(position);
  }

  @Override
  public int getItemCount() {
    if (movies != null && movies.size() > 1) {
      return movies.size();
    } else {
      return 1;
    }
  }

  @Override
  public int getItemViewType(int position) {
    if (movies != null && movies.size() > 0) {
      return VIEW_TYPE_NORMAL;
    } else {
      return VIEW_TYPE_EMPTY;
    }
  }

  public void addItems(List<MovieObject> listObjects) {

    movies.addAll(listObjects);
    cacheImages();
    notifyDataSetChanged();
  }

  public class ViewHolder extends BaseViewHolder {

    @BindView(R.id.movie_item_image)
    ImageView itemImage;

    @BindView(R.id.movie_item_overview)
    TextView overView;

    @BindView(R.id.movie_item_title)
    TextView title;

    @BindView(R.id.movie_item_release_date)
    TextView releaseDate;

    @BindView(R.id.movie_item_vote_average)
    TextView voteAverage;


    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }

    @Override
    protected void clear() {

    }


    public void onBind(final int position) {
      super.onBind(position);

      MovieObject movieObject = movies.get(position);
      title.setText(movieObject.getTitle());
      overView.setText(movieObject.getOverview());
      voteAverage.setText(
          "Voted " + Double.toString(movieObject.getVoteAverage()) + "points by " + movieObject
              .getVoteCount() + " users");
      releaseDate.setText(movieObject.getReleaseDate());
      Picasso.get().load(ApiEndPoint.IMAGE_BASE + movieObject.getPosterPath())
          .networkPolicy(NetworkPolicy.OFFLINE)
          .into(itemImage);

    }
  }

  public class EmptyViewHolder extends BaseViewHolder {


    public EmptyViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }

    @Override
    protected void clear() {

    }
  }

  private void cacheImages() {
    for (MovieObject movieObject : movies) {
      Picasso.get().load(ApiEndPoint.IMAGE_BASE + movieObject.getPosterPath()).fetch();
    }
  }

  public interface Callback {

  }

}
