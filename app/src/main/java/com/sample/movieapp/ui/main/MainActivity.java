package com.sample.movieapp.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.sample.movieapp.R;
import com.sample.movieapp.data.network.model.MovieResponse;
import com.sample.movieapp.ui.base.BaseActivity;

import com.sample.movieapp.ui.popular.PopularFragment;
import com.sample.movieapp.ui.top.TopFragment;
import com.sample.movieapp.ui.upcoming.UpcomingFragment;
import com.sample.movieapp.util.NetworkUtils;
import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainMvpView,
    BottomNavigationView.OnNavigationItemSelectedListener {

  @Inject
  MainMvpPresenter<MainMvpView> mPresenter;

  @BindView(R.id.bottom_navigation)
  BottomNavigationView bottomNavigationView;

  public static Intent getStartIntent(Context context) {
    Intent intent = new Intent(context, MainActivity.class);
    return intent;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    getActivityComponent().inject(this);

    setUnBinder(ButterKnife.bind(this));

    mPresenter.onAttach(this);

    setUp();
  }

  @Override
  protected void setUp() {
    bottomNavigationView.setOnNavigationItemSelectedListener(this);
    openTopFragment();
  }

  @Override
  public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
    switch (menuItem.getItemId()) {
      case R.id.action_top:
        openTopFragment();
        break;
      case R.id.action_upcoming:
        openUpcomingFragment();
        break;
      case R.id.action_popular:
        openPopularFragment();
        break;
    }
    return true;
  }

  private void openTopFragment() {
    TopFragment topFragment = TopFragment.newInstance();
    if (!NetworkUtils.isNetworkConnected(this)) {
      if (getRealm().where(MovieResponse.class).equalTo("category", 0).findFirst() == null) {
        showMessage("You need network connection to download movies to DB.");
        return;
      }
    }
    getSupportFragmentManager()
        .beginTransaction().addToBackStack(TopFragment.TAG)
        .replace(R.id.content_frame, topFragment,
            TopFragment.TAG)
        .commit();

  }

  private void openUpcomingFragment() {
    UpcomingFragment upcomingFragment = UpcomingFragment.newInstance();
    if (!NetworkUtils.isNetworkConnected(this)) {
      if (getRealm().where(MovieResponse.class).equalTo("category", 1).findFirst() == null) {
        showMessage("You need network connection to download movies to DB.");
        return;
      }
    }
    getSupportFragmentManager()
        .beginTransaction().addToBackStack(UpcomingFragment.TAG)
        .replace(R.id.content_frame, upcomingFragment,
            UpcomingFragment.TAG)
        .commit();
  }

  private void openPopularFragment() {
    PopularFragment popularFragment = PopularFragment.newInstance();
    if (!NetworkUtils.isNetworkConnected(this)) {
      if (getRealm().where(MovieResponse.class).equalTo("category", 2).findFirst() == null) {
        showMessage("You need network connection to download movies to DB.");
        return;
      }
    }
    getSupportFragmentManager()
        .beginTransaction().addToBackStack(PopularFragment.TAG)
        .replace(R.id.content_frame, popularFragment,
            PopularFragment.TAG)
        .commit();
  }
}