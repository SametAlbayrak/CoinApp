package com.samet.coinApp.adapters;

import android.content.Context;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.samet.coinApp.R;
import com.samet.coinApp.listeners.OnItemClickListener;
import com.samet.coinApp.models.Coin;
import com.samet.coinApp.models.Data;
import com.samet.coinApp.listeners.OnLoadMoreListener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Samet Albayrak on 24/04/19.
 */

public class HomeCoinAdapter extends RecyclerView.Adapter<HomeCoinAdapter.ItemViewHolder> {

    private List<Data> currencyList;
    private Context context;
    private OnLoadMoreListener onLoadMoreListener;
    private OnItemClickListener onItemClickListener;

    private boolean isLoading = false;
    private int visibleThreshold = 4;
    private int lastVisibleItem, totalItemCount;

    private Map<String, Coin> cryptoListIcons = new HashMap<>();


    public HomeCoinAdapter(Context context, RecyclerView recyclerView) { //List<Data> currencyList,
        this.context = context;


        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                totalItemCount = linearLayoutManager.getItemCount();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                if (!isLoading && totalItemCount < (lastVisibleItem + visibleThreshold)) {
                    if (onLoadMoreListener != null) {
                        onLoadMoreListener.onLoadMore();
                    }
                    isLoading = true;
                }
            }
        });

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_coin, parent, false);
        ItemViewHolder mh = new ItemViewHolder(v);
        return mh;
    }


    @Override
    public void onBindViewHolder(final ItemViewHolder holder, int position) {
        final Data data = currencyList.get(holder.getAdapterPosition());


        holder.tvTitle.setText(String.valueOf(currencyList.get(holder.getAdapterPosition()).getSymbol()));
        holder.tvSymbol.setText(currencyList.get(holder.getAdapterPosition()).getName());
        holder.tvPrice.setText(String.valueOf(currencyList.get(holder.getAdapterPosition()).getQuote().getUSD().getPrice()));
        holder.tvPriceTitle.setText("Price (USD)");

        final String logoURL = cryptoListIcons.get(data.getSymbol()).getLogo();
        Glide.with(context).load(logoURL).into(holder.ivCoinImage);

        holder.rootView.setOnClickListener(view -> {

            if (onItemClickListener != null) {
                onItemClickListener.onItemClicked(logoURL, currencyList.get(holder.getAdapterPosition()));
            }
        });

    }


    @Override
    public int getItemCount() {
        return currencyList == null ? 0 : currencyList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvSymbol, tvPrice, tvPriceTitle;
        ImageView ivCoinImage;
        CardView rootView;

        private ItemViewHolder(View view) {
            super(view);
            tvTitle = view.findViewById(R.id.tvTitle);
            tvSymbol = view.findViewById(R.id.tvOverView);
            tvPrice = view.findViewById(R.id.tvPrice);
            ivCoinImage = view.findViewById(R.id.ivCoin);
            tvPriceTitle = view.findViewById(R.id.tvPriceTitle);
            rootView = view.findViewById(R.id.cvRootItem);
        }
    }

    public void updateData(List<Data> currencyList, Map<String, Coin> cryptoListIcons) {
        this.currencyList = currencyList;
        this.cryptoListIcons = cryptoListIcons;
        notifyDataSetChanged();
    }


    public void setLoaded() {
        isLoading = false;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
    public void setOnLoadMoreListener(OnLoadMoreListener mOnLoadMoreListener) {
        this.onLoadMoreListener = mOnLoadMoreListener;
    }

}
