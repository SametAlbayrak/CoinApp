package com.samet.coinApp.di.modules;

import android.content.Context;

import com.samet.coinApp.network.APIClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class ApiClientModule {

    private Context context;

    public ApiClientModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public APIClient provideRetrofitClient() {
        return new APIClient(context);
    }
}
