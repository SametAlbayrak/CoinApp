package com.samet.coinApp.models

import com.google.gson.annotations.SerializedName

data class CryptoData(
    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("symbol")
    val symbol: String? = null,

    @SerializedName("slug")
    val slug: String? = null,

    @SerializedName("circulating_supply")
    val circulatingSupply: Double? = null,

    @SerializedName("total_supply")
    val totalSupply: Double? = null,

    @SerializedName("max_supply")
    val maxSupply: Double? = null,

    @SerializedName("date_added")
    val dateAdded: String? = null,

    @SerializedName("num_market_pairs")
    val numMarketPairs: Int? = null,

    @SerializedName("cmc_rank")
    val cmcRank: Int? = null,

    @SerializedName("last_updated")
    val lastUpdated: String? = null,

    @SerializedName("quote")
    val quote: Quote? = null
)
