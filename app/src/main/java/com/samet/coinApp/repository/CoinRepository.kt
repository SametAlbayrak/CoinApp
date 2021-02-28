package com.samet.coinApp.repository

import com.samet.coinApp.api.ApiService
import javax.inject.Inject

class CoinRepository @Inject constructor(private val apiService: ApiService) {


    suspend fun getCoinListLatest(start: String?, limit: String?) = apiService.getCoinListLatest(start = start, limit = limit)

    suspend fun getCryptoCurrencyInfo(coinSymbol : String?) = apiService.getCryptoCurrencyInfo(coinSymbol)
}