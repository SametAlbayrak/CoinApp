package com.samet.coinApp.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.samet.coinApp.models.CryptoData

class HomeCoinAdapterV2(private val onItemClickListener: (Int) -> Unit) : ListAdapter<CryptoData, CoinViewHolder>(DiffUtils()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        return CoinViewHolder(parent)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.bind(getItem(position), onItemClickListener)
    }

}