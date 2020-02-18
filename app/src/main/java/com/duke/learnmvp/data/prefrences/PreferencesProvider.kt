package com.duke.learnmvp.data.prefrences

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

object PreferencesProvider {
    private val SHARED_PREFERENCES = "learnMVP"

    private var sPreferences: SharedPreferences? = null

    fun providePreferences(): SharedPreferences? {
        return sPreferences
    }

    fun init(context: Context?) {
        sPreferences = context?.getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE)
    }
}