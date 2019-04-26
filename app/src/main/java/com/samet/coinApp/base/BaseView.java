package com.samet.coinApp.base;

public interface BaseView<T> {

    void showServerError(String errorCode);

    void showConnectionError();

}
