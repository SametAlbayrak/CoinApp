package com.samet.coinApp.ui.detail;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.samet.coinApp.R;
import com.samet.coinApp.custom.CustomDetailView;
import com.samet.coinApp.models.Data;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailFragment extends BaseFragment implements DetailContract.View {

    @BindView(R.id.ivCoinImage)
    ImageView coinImage;

    @BindView(R.id.cDetail1)
    CustomDetailView detailView1;

    @BindView(R.id.tvName)
    TextView tvName;

    @BindView(R.id.cDetail2)
    CustomDetailView detailView2;

    @BindView(R.id.cDetail3)
    CustomDetailView detailView3;

    @BindView(R.id.cDetail4)
    CustomDetailView detailView4;

    @Inject
    DetailPresenter mPresenter;

    Data data;
    String imgUrl;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_details, container, false);
        ButterKnife.bind(this, root);
        mPresenter.takeView(this);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.getArguments();
    }


    @Override
    public void onGetArguments() {
        if (getArguments() == null) return;
        data = (Data) getArguments().get(Constant.BUNDLE_DETAIL_KEY);
        imgUrl = getArguments().getString(Constant.BUNDLE_IMAGE_URL);
        if (data != null)
            mPresenter.setDetails();

    }


    @Override
    public void onSetDetails() {
        if (getContext() != null)
            Glide.with(getContext()).load(imgUrl).into(coinImage);
        detailView1.setLeftText(data.getSymbol() + getString(R.string.coin_price));
        detailView1.setRightTextView(String.valueOf(data.getQuote().getUSD().getPrice()));

        detailView2.setRightTextView(String.valueOf(data.getQuote().getUSD().getVolume24h()));
        detailView2.setLeftText(getString(R.string.coin_volume));

        detailView3.setLeftText(getString(R.string.coin_total_suply));
        detailView3.setRightTextView(String.valueOf(data.getTotalSupply()));

        detailView4.setLeftText(getString(R.string.coin_market_pairs));
        detailView4.setRightTextView(String.valueOf(data.getNumMarketPairs()));
        tvName.setText(data.getName());
    }

}


