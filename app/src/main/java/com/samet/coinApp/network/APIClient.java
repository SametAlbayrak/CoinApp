package com.samet.coinApp.network;


import android.content.Context;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Samet Albayrak on 24/04/19.
 */

@Singleton
public class APIClient {


    private static int REQUEST_TIMEOUT = 30;
    private static OkHttpClient okHttpClient;
    private static String BASE_URL = "https://pro-api.coinmarketcap.com";

    private Context context;
    private APIService apiService = null;
    private Retrofit retrofit = null;


    @Inject
    public APIClient(Context context) {
        this.context = context;
    }


    private static void initOkHttp() {
        OkHttpClient.Builder httpClient = new OkHttpClient().newBuilder()
                .connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(); //logging
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        httpClient.addInterceptor(interceptor);

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request.Builder requestBuilder = original.newBuilder()
                        .addHeader("Accept", "application/json")
                        .addHeader("Content-Type", "application/json");

                requestBuilder.addHeader("X-CMC_PRO_API_KEY", "103725a7-8317-4e13-86eb-7cdc288f51ce");

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });

        okHttpClient = httpClient.build();
    }


    private void getClient() {
        if (okHttpClient == null)
            initOkHttp();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
    }

    public APIService getRetrofitService() {
        if (retrofit == null) {
            getClient();
        }
        if (retrofit != null && apiService == null) {
            apiService = retrofit.create(APIService.class);
        }
        return apiService;
    }


}
