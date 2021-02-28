package com.samet.coinApp.usecase

import com.samet.coinApp.models.CryptoList
import com.samet.coinApp.models.Info
import com.samet.coinApp.repository.CoinRepository
import com.samet.coinApp.util.Resource
import javax.inject.Inject

class UseCase @Inject constructor(private val repository: CoinRepository) {


    suspend fun getCoinListLatest(start: String?, limit: String?): Resource<CryptoList> {
        val coinList = repository.getCoinListLatest(start, limit)

        return if (!coinList?.data.isNullOrEmpty()) {
            Resource.Success(coinList)
        } else {
            Resource.Failed("serviste hata olustu")
        }
    }


    suspend fun getCryptoCurrencyInfo(coinSymbol: String?): Resource<Info> {
        val coinInfo = repository.getCryptoCurrencyInfo(coinSymbol)

        return if (!coinInfo?.data.isNullOrEmpty()) {
            Resource.Success(coinInfo)
        } else {
            Resource.Failed("serviste hata olustu")
        }
    }

}