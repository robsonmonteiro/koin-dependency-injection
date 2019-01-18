package com.robsonmonteiro.koindependencyinjection.data

import com.robsonmonteiro.koindependencyinjection.model.Currency

interface DataRepository {

    fun getCurrencies(jsonString: String): List<Currency>

}