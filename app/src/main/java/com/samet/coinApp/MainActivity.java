package com.samet.coinApp;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.samet.coinApp.ui.home.HomeFragment;
import com.samet.coinApp.util.FragmentTransactionUtils;

import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        openFragment();
    }

    public void openFragment() {
        FragmentTransactionUtils.replaceFragmentToActivityWithCustomAnimation(this,
                new HomeFragment(), R.id.fl_fragment_container, R.anim.slide_enter_in, R.anim.slide_enter_out);
    }

}
