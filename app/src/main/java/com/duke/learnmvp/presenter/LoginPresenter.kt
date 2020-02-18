package com.duke.learnmvp.presenter

import android.content.Intent
import android.text.TextUtils
import com.duke.learnmvp.data.prefrences.UserPreferences
import com.duke.learnmvp.data.prefrences.UserPreferencesImpl
import com.duke.learnmvp.view.activities.views.LoginActivityView

class LoginPresenter(private val mView: LoginActivityView) : AbstractPresenter() {

    internal var mDatabase: UserPreferences = UserPreferencesImpl()

    fun onCreate(intent: Intent) {
        // Handle intent data here...
    }

    fun login(username: String, password: String) {
        if (TextUtils.isEmpty(username)) {
            mView.showError("Please enter username")
        } else if (username.length < 6) {
            mView.showError("Username must contains 6 letters")
        } else if (TextUtils.isEmpty(password)) {
            mView.showError("Please enter password")
        } else if (password.length < 6) {
            mView.showError("Password must contains 6 letters")
        } else {
            mDatabase.setUserLogin(true)
            mView.showMainActivity()
        }
    }
}