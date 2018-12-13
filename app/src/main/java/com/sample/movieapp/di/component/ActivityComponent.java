package com.sample.movieapp.di.component;


import com.sample.movieapp.di.PerActivity;
import com.sample.movieapp.di.module.ActivityModule;
import com.sample.movieapp.ui.main.MainActivity;
import com.sample.movieapp.ui.popular.PopularFragment;
import com.sample.movieapp.ui.top.TopFragment;
import com.sample.movieapp.ui.upcoming.UpcomingFragment;
import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

    void inject(TopFragment fragment);

    void inject(UpcomingFragment fragment);

    void inject(PopularFragment fragment);
}
