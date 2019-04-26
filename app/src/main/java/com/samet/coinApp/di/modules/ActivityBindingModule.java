package com.samet.coinApp.di.modules;

import com.samet.coinApp.MainActivity;
import com.samet.coinApp.di.scoped.ActivityScoped;
import com.samet.coinApp.ui.detail.DetailModule;
import com.samet.coinApp.ui.home.HomeModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = {
            HomeModule.class,
            DetailModule.class})

    abstract MainActivity mainActivity();


}