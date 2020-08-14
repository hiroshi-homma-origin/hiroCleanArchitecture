package com.kotlin.cleanarchitecture

import android.app.Application
import timber.log.Timber
import timber.log.Timber.DebugTree

open class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(DebugTree())
    }
}
