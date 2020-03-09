package com.samet.coinApp.util;

import androidx.annotation.AnimRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.samet.coinApp.R;

public class FragmentTransactionUtils {


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
        transaction.disallowAddToBackStack();
        transaction.commitAllowingStateLoss();
    }


    public static void addFragmentToActivity(FragmentActivity activity, Fragment fragment, int frameId,
                                             boolean addToBackStack, boolean animate) {
        if (activity == null || fragment == null) return;
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        if (fragmentManager == null) return;
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (animate)
            transaction.setCustomAnimations(R.anim.slide_enter_in, R.anim.slide_enter_out, R.anim.slide_back_in,
                    R.anim.slide_back_out);
        transaction.add(frameId, fragment, fragment.getClass().getSimpleName());
        if (addToBackStack) transaction.addToBackStack(fragment.getClass().getSimpleName());
        transaction.commitAllowingStateLoss();
    }

}
