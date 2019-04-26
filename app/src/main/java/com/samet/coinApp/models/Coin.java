package com.samet.coinApp.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Coin implements Serializable {

    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    @SerializedName("symbol")
    private String symbol;

    @SerializedName("logo")
    private String logo;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogo() {
        return logo;
    }
}
