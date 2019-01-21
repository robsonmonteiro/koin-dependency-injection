package com.robsonmonteiro.koindependencyinjection.presentation

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.robsonmonteiro.koindependencyinjection.data.DataRepository
import com.robsonmonteiro.koindependencyinjection.model.Currency

class CurrenciesViewModel constructor(
    private val dataRepository: DataRepository,
    private val jsonString: String
) : ViewModel() {

    private val currencyLiveData = MutableLiveData<List<Currency>>()

    fun observeCurrencies(): LiveData<List<Currency>> = currencyLiveData

    fun retrieveCurrencies() {
        val data = dataRepository.getCurrencies(jsonString)
        currencyLiveData.postValue(data)
    }

}