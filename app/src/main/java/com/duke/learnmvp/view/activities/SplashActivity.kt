package com.duke.learnmvp.view.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.duke.learnmvp.R
import com.duke.learnmvp.presenter.Presenter
import com.duke.learnmvp.presenter.SplashPresenter
import com.duke.learnmvp.view.activities.views.SplashActivityView

class SplashActivity : AbstractActivity(), SplashActivityView {

    private var mPresenter = SplashPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        mPresenter.onCreate(intent)

        Handler().postDelayed({ mPresenter.checkUserIsLogin() }, 2000)
    }

    override fun getPresenter(): Presenter {
        return mPresenter
    }

    override fun showLoginActivity() {
        startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        finish()
    }

    override fun showMainActivity() {
        startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        finish()
    }

}
