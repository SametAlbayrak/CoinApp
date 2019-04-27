package com.samet.coinApp.ui.home;

import com.samet.coinApp.models.Data;
import com.samet.coinApp.models.Info;

import java.util.List;

public interface HomeContract {

    interface View {

        void onInitViews();

        void showToast(String s);

        void showProgressBar();

        void hideProgressBar();

        void displayError(String s);

        void setAdapterItemList(Info info, List<Data> currencyList);

        void setRefresing();

        void onSetRefreshLayoutListener();

        void onSetInitialRequest();

    }

    interface Presenter {

        void initViews();

        void getCurrencies(String start, String limit);

        void setRefreshLayoutListener();

        void setInitialRequest();

        void clearCurrencyList();

    }
}