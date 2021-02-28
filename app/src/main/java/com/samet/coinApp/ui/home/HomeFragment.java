package com.samet.coinApp.ui.home;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.samet.coinApp.R;
import com.samet.coinApp.adapters.HomeCoinAdapter;
import com.samet.coinApp.listeners.OnItemClickListener;
import com.samet.coinApp.listeners.OnLoadMoreListener;
import com.samet.coinApp.models.Data;
import com.samet.coinApp.models.Info;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/*

public class HomeFragment extends BaseFragment implements HomeContract.View,
        OnLoadMoreListener,
        OnItemClickListener {

    @Inject
    HomePresenter mPresenter;

    @BindView(R.id.rvMovies)
    RecyclerView rvMovies;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.swipe_to_refresh)
    SwipeRefreshLayout swipeRefreshLayout;

    HomeCoinAdapter adapter;
    List<Data> ccList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, root);
        mPresenter.takeView(this); // to initialize view for presenter
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.initViews();
        mPresenter.setRefreshLayoutListener();
        mPresenter.setInitialRequest();
    }


    @Override
    public void onSetRefreshLayoutListener() {
        swipeRefreshLayout.setOnRefreshListener(() -> {
            mPresenter.clearCurrencyList();
            mPresenter.getCurrencies(Constant.FETCH_START, Constant.FETCH_LIMIT);
        });
    }

    @Override
    public void onSetInitialRequest() {
        //first initial call
        swipeRefreshLayout.postDelayed(() ->
                mPresenter.getCurrencies(Constant.FETCH_START, Constant.FETCH_LIMIT), 200);
    }


    @Override
    public void setRefresing() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void setAdapterItemList(Info info, List<Data> currencyList) {
        ccList = new ArrayList<>();
        ccList.addAll(currencyList);
        adapter.updateData(ccList, info.getData());
        adapter.setLoaded();
    }

    @Override
    public void onInitViews() {
        rvMovies.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new HomeCoinAdapter(getContext(), rvMovies);
        adapter.setOnLoadMoreListener(this);
        adapter.setOnItemClickListener(this);
        rvMovies.setAdapter(adapter);
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getContext(), message , Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void displayError(String errorMessage) {
        showToast(errorMessage);
    }

    @Override
    public void onLoadMore() {
        if (ccList.size() <= Constant.MAX_COIN_SIZE) {
            mPresenter.getCurrencies(String.valueOf(ccList.size() + 1), Constant.FETCH_LIMIT);
        } else
            displayError(getString(R.string.error_reached_max_coin_size));
    }

    @Override
    public void onItemClicked(String imgUrl, Data data) {
        DetailFragment detailFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constant.BUNDLE_DETAIL_KEY, data);
        bundle.putString(Constant.BUNDLE_IMAGE_URL, imgUrl);
        detailFragment.setArguments(bundle);
        FragmentTransactionUtils.addFragmentToActivity(getActivity(),
                detailFragment, R.id.fl_fragment_container, true, true);
    }


    @Override
    public void onBackPressed() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }


}

*/
