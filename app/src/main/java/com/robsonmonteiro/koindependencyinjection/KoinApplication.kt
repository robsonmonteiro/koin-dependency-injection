package com.robsonmonteiro.koindependencyinjection

import android.app.Application
import org.koin.android.ext.android.startKoin
import timber.log.Timber

class KoinApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin(this, listOf(applicationModule), loadProperties = true, logger = KoinLogger())
    }

}