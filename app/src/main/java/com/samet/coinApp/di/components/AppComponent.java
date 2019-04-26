package com.samet.coinApp.di.components;

import android.app.Application;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

import com.samet.coinApp.CoinApplication;
import com.samet.coinApp.di.modules.ApiClientModule;
import com.samet.coinApp.di.modules.ActivityBindingModule;

import javax.inject.Singleton;


@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ApiClientModule.class,
        ActivityBindingModule.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    void inject(CoinApplication application);

    void inject(ApiClientModule apiClientModule);


    @Override
    void inject(DaggerApplication instance);


    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent.Builder apiClientModule(ApiClientModule apiClientModule);

        AppComponent build();
    }

}

