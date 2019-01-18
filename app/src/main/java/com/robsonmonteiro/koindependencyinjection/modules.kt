package com.robsonmonteiro.koindependencyinjection

import com.google.gson.Gson
import com.robsonmonteiro.koindependencyinjection.data.DataRepository
import com.robsonmonteiro.koindependencyinjection.data.DataRepositoryFactory
import com.robsonmonteiro.koindependencyinjection.data.LocalDataRepository
import com.robsonmonteiro.koindependencyinjection.data.RemoteDataRepository
import com.robsonmonteiro.koindependencyinjection.presentation.CurrenciesAdapter
import com.robsonmonteiro.koindependencyinjection.presentation.CurrenciesViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val applicationModule = module() {
    single { Gson() }

    single { UrlHelper(getProperty("currency_base_url")) }

    scope("browse") { CurrenciesAdapter() }

    factory<DataRepository>("local") { LocalDataRepository(get()) }
    factory<DataRepository>("remote") { RemoteDataRepository() }

    factory<DataRepositoryFactory> { DataRepositoryFactory(get("local"), get("remote")) }

    viewModel { (jsonString: String) -> CurrenciesViewModel(get(), jsonString) }

}