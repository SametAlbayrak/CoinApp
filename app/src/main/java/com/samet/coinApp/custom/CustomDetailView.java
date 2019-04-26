package com.samet.coinApp.custom;

import android.animation.LayoutTransition;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.samet.coinApp.R;


/**
 * Created by Samet Albayrak on 25/04/19.
 */
public class CustomDetailView extends ConstraintLayout {


    private TextView leftTextView;
    private TextView rightTextView;

    public CustomDetailView(Context context) {
        super(context);
        init();
    }

    public CustomDetailView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomDetailView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.custom_detail_view, this, true);
        leftTextView = findViewById(R.id.tvLeftText);
        rightTextView = findViewById(R.id.tvRightText);
    }

    public void setLeftText(String str) {
        leftTextView.setText(str);
    }

    public void setRightTextView(String str) {
        rightTextView.setText(str);
    }

}
