package com.samet.coinApp.models;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class CryptoList implements Serializable {

    @SerializedName("data")
    private List<Data> data;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

}