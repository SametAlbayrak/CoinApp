package com.samet.coinApp.adapters

import androidx.recyclerview.widget.DiffUtil
import com.samet.coinApp.models.CryptoData

class DiffUtils : DiffUtil.ItemCallback<CryptoData>() {
    override fun areItemsTheSame(oldItem: CryptoData, newItem: CryptoData): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CryptoData, newItem: CryptoData): Boolean {
        return oldItem == newItem
    }

}