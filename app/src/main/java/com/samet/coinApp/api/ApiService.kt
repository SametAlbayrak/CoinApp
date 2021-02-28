package com.samet.coinApp.api

import com.samet.coinApp.models.CryptoList
import com.samet.coinApp.models.Info
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/v1/cryptocurrency/listings/latest?")
    suspend fun getCoinListLatest(
        @Query("start") start: String?,
        @Query("limit") limit: String?
    ): CryptoList?

    @GET("/v1/cryptocurrency/info")
    suspend fun getCryptoCurrencyInfo(@Query("symbol") symbol: String?): Info?
}