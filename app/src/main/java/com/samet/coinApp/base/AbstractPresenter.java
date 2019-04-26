package com.samet.coinApp.base;

import io.reactivex.annotations.Nullable;


/**
 * Created by Samet Albayrak on 24/04/19.
 */
public abstract class AbstractPresenter<T> implements BasePresenter<T> {

    @Nullable
    private T view;

    @Nullable
    public T getView() {
        return view;
    }

    @Override
    public void takeView(T view) {
        this.view = view;
    }

    @Override
    public void dropView() {
        view = null;
    }
}
