package com.samet.coinApp.ui.detail;

import com.samet.coinApp.base.AbstractPresenter;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class DetailPresenter extends AbstractPresenter<DetailContract.View> implements DetailContract.Presenter {

    @Inject
    public DetailPresenter() {
        //Nothing is done in this constructor
    }

}
