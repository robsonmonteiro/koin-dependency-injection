package com.robsonmonteiro.koindependencyinjection.presentation

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.robsonmonteiro.koindependencyinjection.data.DataRepositoryFactory
import com.robsonmonteiro.koindependencyinjection.model.Currency

class CurrenciesViewModel constructor(
    private val dataRepositoryFactory: DataRepositoryFactory,
    private val jsonString: String
) : ViewModel() {

    private val currencyLiveData = MutableLiveData<List<Currency>>()

    fun observeCurrencies(): LiveData<List<Currency>> = currencyLiveData

    fun retrieveCurrencies() {
        val data = dataRepositoryFactory.retriveLocalSource().getCurrencies(jsonString)
        currencyLiveData.postValue(data)
    }

}