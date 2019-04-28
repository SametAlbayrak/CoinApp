package com.samet.coinApp.ui.home;


import android.util.Log;

import com.samet.coinApp.base.AbstractPresenter;
import com.samet.coinApp.models.CryptoList;
import com.samet.coinApp.models.Data;
import com.samet.coinApp.models.Info;
import com.samet.coinApp.network.APIClient;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class HomePresenter extends AbstractPresenter<HomeContract.View> implements HomeContract.Presenter {

    @Inject
    APIClient apiClient;

    private String TAG = "HomePresenter";
    private List<Data> currencyList = new ArrayList<>();

    @Inject
    public HomePresenter() {
        //empty constructor
    }

    @Override
    public void getCurrencies(String start, String limit) {
        if (getView() == null) return;

        apiClient.getRetrofitService()
                .getListLatest(start, limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CryptoList>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        getView().showProgressBar();
                    }

                    @Override
                    public void onNext(CryptoList cryptoList) {
                        if (getView() == null) return;

                        currencyList.addAll(cryptoList.getData());
                        getCurrencyIconList(currencyList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "Error" + e);
                        e.printStackTrace();
                        getView().displayError("coin datası çekilirken bir hata oluştu!");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "Completed");
                        getView().setRefresing();
                    }
                });
    }


    public void getCurrencyIconList(final List<Data> cList) {

        apiClient.getRetrofitService()
                .getCryptocurrencyInfo(prepareCurrencySymbols())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Info>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Info info) {
                        if (getView() == null) return;
                        getView().setAdapterItemList(info, cList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "Error" + e);
                        getView().displayError("coin iconları çekilirken hata oluştu!");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "Completed");
                        getView().hideProgressBar();
                        getView().setRefresing();
                    }
                });
    }


    @Override
    public void setRefreshLayoutListener() {
        if (getView() == null) return;
        getView().onSetRefreshLayoutListener();
    }


    @Override
    public void setInitialRequest() {
        if (getView() == null) return;
        getView().onSetInitialRequest();
    }

    @Override
    public void clearCurrencyList() {
        currencyList.clear();
    }

    @Override
    public void initViews() {
        if (getView() == null) return;
        getView().onInitViews();
    }

    @Override
    public String prepareCurrencySymbols() {
        String sep = ",";
        StringBuilder stringBuilder = new StringBuilder();
        for (Data dt : currencyList) {
            stringBuilder.append(dt.getSymbol());
            stringBuilder.append(sep);
        }

        String currencySymbols = stringBuilder.toString();
        return stringBuilder.substring(0, currencySymbols.length() - sep.length());

    }


}
