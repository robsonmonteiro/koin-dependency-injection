package com.robsonmonteiro.koindependencyinjection

import com.robsonmonteiro.koindependencyinjection.model.Currency

object CurrencyFactory {

    fun makeCurrency(): Currency {
        return Currency(
            DataFactory.randomInt(), DataFactory.randomUuid(),
            DataFactory.randomUuid(), DataFactory.randomUuid()
        )
    }

    fun makeCurrencyList(count: Int): List<Currency> = (0..count).map { makeCurrency() }

}

