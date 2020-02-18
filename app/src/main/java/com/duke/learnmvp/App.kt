package com.duke.learnmvp

import android.app.Application
import com.duke.learnmvp.data.prefrences.PreferencesProvider

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        PreferencesProvider.init(applicationContext)
    }
}