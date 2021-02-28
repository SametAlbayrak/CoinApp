package com.samet.coinApp.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.*

import com.samet.coinApp.models.CryptoList
import com.samet.coinApp.usecase.UseCase
import com.samet.coinApp.util.Resource
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(private val useCase: UseCase) : ViewModel() {

    private var _coinList = MutableLiveData<Resource<CryptoList>>()
    val coinList: LiveData<Resource<CryptoList>>
        get() = _coinList


    fun getCoinList(start: String?, limit: String?) = viewModelScope.launch {
        _coinList = liveData {

            emit(Resource.Loading())
            emit(useCase.getCoinListLatest(start, limit))

        } as MutableLiveData<Resource<CryptoList>>
    }

}