package com.samet.coinApp;

import com.samet.coinApp.di.components.AppComponent;
import com.samet.coinApp.di.components.DaggerAppComponent;
import com.samet.coinApp.di.modules.ApiClientModule;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * Created by Samet Albayrak on 24/04/19.
 */
public class CoinApplication extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = getAppComponent();
        appComponent.inject(this);
        return appComponent;
    }

    private AppComponent getAppComponent() {
        ApiClientModule apiClientModule = new ApiClientModule(this);
        return DaggerAppComponent.builder()
                .apiClientModule(apiClientModule)
                .application(this).build();

    }


}