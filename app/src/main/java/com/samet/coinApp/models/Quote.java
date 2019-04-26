package com.samet.coinApp.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Quote implements Serializable {

    @SerializedName("USD")
    private USD usd;

    public USD getUSD() {
        return usd;
    }

    public void setUSD(USD uSD) {
        this.usd = uSD;
    }

}