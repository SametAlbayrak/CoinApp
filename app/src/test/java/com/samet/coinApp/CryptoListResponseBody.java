package com.samet.coinApp;

import android.support.annotation.NonNull;

import com.google.gson.GsonBuilder;
import com.samet.coinApp.models.CryptoList;
import com.samet.coinApp.models.Data;
import com.samet.coinApp.models.Quote;

import java.util.ArrayList;
import java.util.List;

public class CryptoListResponseBody {

    public static String getCryptoList() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        CryptoList cryptoList = new CryptoList();
        cryptoList.setData(getCrpytoList());
        return gsonBuilder.create().toJson(cryptoList);
    }

    @NonNull
    public static List<Data> getCrpytoList() {
        List<Data> liste = new ArrayList<>();
        liste.add(getCrpytoData(1));
        liste.add(getCrpytoData(2));
        liste.add(getCrpytoData(3));
        liste.add(getCrpytoData(4));
        liste.add(getCrpytoData(5));
        return liste;
    }

    @NonNull
    private static Data getCrpytoData(int x) {
        Data item = new Data();
        item.setId(x);
        item.setName("Bitcoin");
        item.setCirculatingSupply(44.0);
        item.setCmcRank(300);
        item.setDateAdded("2019");
        item.setNumMarketPairs(30);
        item.setSlug("sametttt");
        item.setSymbol("BTC");
        item.setQuote(new Quote());
        return item;
    }
}