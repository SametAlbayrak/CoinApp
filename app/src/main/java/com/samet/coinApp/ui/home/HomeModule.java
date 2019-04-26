package com.samet.coinApp.ui.home;

import com.samet.coinApp.di.scoped.FragmentScoped;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class HomeModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract HomeFragment getHomeFragment();

    @Binds
    abstract HomeContract.Presenter getHomePresenter(HomePresenter homePresenter);


}
