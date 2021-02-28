package com.samet.coinApp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.samet.coinApp.R
import com.samet.coinApp.models.CryptoData

class CoinViewHolder(container: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(container.context).inflate(R.layout.row_coin, container, false)
) {

    fun bind(item: CryptoData, onItemClickListener: (Int) -> Unit) {

        /***
         * bind işlemleri yapılacak.
         */

    }
}