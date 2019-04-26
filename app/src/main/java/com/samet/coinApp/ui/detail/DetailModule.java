package com.samet.coinApp.ui.detail;

import com.samet.coinApp.di.scoped.FragmentScoped;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class DetailModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract DetailFragment getDetailFragment();

    @Binds
    abstract DetailContract.Presenter getDetailPresenter(DetailPresenter detailPresenter);


}