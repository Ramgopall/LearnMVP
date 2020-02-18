package com.duke.learnmvp.presenter

import android.content.Intent
import com.duke.learnmvp.data.prefrences.UserPreferences
import com.duke.learnmvp.data.prefrences.UserPreferencesImpl
import com.duke.learnmvp.view.activities.views.SplashActivityView

class SplashPresenter(private val mView: SplashActivityView) : AbstractPresenter() {

    private var mDatabase: UserPreferences = UserPreferencesImpl()

    fun onCreate(intent: Intent) {
        // Handle intent data here...
    }

    fun checkUserIsLogin() {
        if (mDatabase.isUserLogin()!!) {
            mView.showMainActivity()
        } else {
            mView.showLoginActivity()
        }
    }
}