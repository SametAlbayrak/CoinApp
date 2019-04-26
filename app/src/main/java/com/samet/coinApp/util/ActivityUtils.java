package com.samet.coinApp.util;

import android.support.annotation.AnimRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.samet.coinApp.R;

public class ActivityUtils {


    // clear all fragments from fragment stack
    public static void clearAllFragmentFromStack(FragmentActivity activity) {
        FragmentManager fm = activity.getSupportFragmentManager();
        fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }


    public static void replaceFragmentToActivity(FragmentActivity activity,
                                                 Fragment fragment, int frameId, boolean addToBackStack, boolean animate) {

        if (activity == null || fragment == null) return;
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        if (fragmentManager == null) return;
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (animate)
            transaction.setCustomAnimations(R.anim.slide_enter_in, R.anim.slide_enter_out, R.anim.slide_back_in, R.anim.slide_back_out);
        transaction.replace(frameId, fragment, fragment.getClass().getSimpleName());
        if (addToBackStack) transaction.addToBackStack(fragment.getClass().getSimpleName());
        transaction.commitAllowingStateLoss();
    }


    public static void replaceFragmentToActivityWithCustomAnimation(FragmentActivity activity,
                                                                    Fragment fragment, int frameId, @AnimRes int animIn, @AnimRes int animOut) {
        if (activity == null || fragment == null) return;
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        if (fragmentManager == null) return;
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(animIn, animOut);
        transaction.replace(frameId, fragment);
        transaction.addToBackStack(fragment.getClass().getSimpleName());
        transaction.commitAllowingStateLoss();
    }
}
