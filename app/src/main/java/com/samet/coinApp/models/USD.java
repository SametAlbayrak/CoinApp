package com.samet.coinApp.models;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class USD implements Serializable {

    @SerializedName("price")
    private Double price;

    @SerializedName("volume_24h")
    private Double volume24h;

    @SerializedName("market_cap")
    private Double marketCap;

    @SerializedName("last_updated")
    private String lastUpdated;


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getVolume24h() {
        return volume24h;
    }

    public void setVolume24h(Double volume24h) {
        this.volume24h = volume24h;
    }

    public Double getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(Double marketCap) {
        this.marketCap = marketCap;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}