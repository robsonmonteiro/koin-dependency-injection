package com.robsonmonteiro.koindependencyinjection.data

import com.google.gson.Gson
import com.robsonmonteiro.koindependencyinjection.model.Currency

class LocalDataRepository(private val gson: Gson) : DataRepository {

    override fun getCurrencies(jsonString: String): List<Currency> {
        return gson.fromJson(jsonString, Array<Currency>::class.java).toList()
    }

}