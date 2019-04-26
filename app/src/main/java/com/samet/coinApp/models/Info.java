package com.samet.coinApp.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Map;

public class Info implements Serializable {

    @SerializedName("data")
    private Map<String, Coin> data;

    public Map<String, Coin> getData() {
        return data;
    }

    public void setData(Map<String, Coin> data) {
        this.data = data;
    }

}
