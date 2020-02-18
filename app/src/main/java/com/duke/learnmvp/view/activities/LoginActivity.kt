package com.duke.learnmvp.view.activities

import android.content.Intent
import android.os.Bundle
import com.duke.learnmvp.R
import com.duke.learnmvp.presenter.LoginPresenter
import com.duke.learnmvp.presenter.Presenter
import com.duke.learnmvp.view.activities.views.LoginActivityView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AbstractActivity(), LoginActivityView {

    private var mPresenter = LoginPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mPresenter.onCreate(intent)
        initListeners()
    }

    private fun initListeners() {
        btnLogin.setOnClickListener {
            mPresenter.login(
                edtUserName.text.toString().trim(),
                edtPassword.text.toString().trim()
            )
        }
    }

    override fun getPresenter(): Presenter {
        return mPresenter
    }

    override fun showError(errorMsg: String) {
        showToast(errorMsg)
    }

    override fun showMainActivity() {
        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        finish()
    }

}
