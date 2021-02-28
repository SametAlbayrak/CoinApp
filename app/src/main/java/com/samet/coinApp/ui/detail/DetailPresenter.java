package com.samet.coinApp.ui.detail;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class DetailPresenter extends AbstractPresenter<DetailContract.View> implements DetailContract.Presenter {

    @Inject
    public DetailPresenter() {
        //emtpy constructor
    }

    @Override
    public void setDetails() {
        if (getView() == null) return;
        getView().onSetDetails();
    }

    @Override
    public void getArguments() {
        if (getView() == null) return;
        getView().onGetArguments();
    }
}
