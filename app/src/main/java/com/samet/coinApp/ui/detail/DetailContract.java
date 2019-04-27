package com.samet.coinApp.ui.detail;

public interface DetailContract {

    interface View {
        void onGetArguments();

        void onSetDetails();


    }

    interface Presenter {

        void setDetails();

        void getArguments();
    }

}
