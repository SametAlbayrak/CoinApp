package com.samet.coinApp.network;


import com.samet.coinApp.models.CryptoList;
import com.samet.coinApp.models.Info;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    @GET("/v1/cryptocurrency/listings/latest?")
    Observable<CryptoList> getMarketPairsLatest(@Query("start") String start, @Query("limit") String limit);

    @GET("/v1/cryptocurrency/info")
    Observable<Info> getCryptocurrencyInfo(@Query("symbol") String symbol);
}
