package com.duke.learnmvp.view.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.duke.learnmvp.R
import com.duke.learnmvp.data.models.Note
import com.duke.learnmvp.presenter.Adapters.NotesAdapter
import com.duke.learnmvp.presenter.MainPresenter
import com.duke.learnmvp.presenter.Presenter
import com.duke.learnmvp.view.activities.views.MainActivityView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AbstractActivity(), MainActivityView {

    private var mPresenter = MainPresenter(this)
    lateinit var mAdapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListener()
        initRecyclerView()

        mPresenter.onCreate(intent)
    }

    override fun getPresenter(): Presenter {
        return mPresenter
    }


    private fun initListener() {
        imgBack.setOnClickListener { finish() }

        btnAddNote.setOnClickListener { mPresenter.addNote(edtNote.text.toString()) }

        btnLogout.setOnClickListener { mPresenter.logoutApp() }
    }

    private fun initRecyclerView() {
        recyclerViewNote.layoutManager = LinearLayoutManager(this)
        mAdapter = NotesAdapter(ArrayList(), mPresenter)
        recyclerViewNote.adapter = mAdapter
    }


    override fun showLoginActivity() {
        startActivity(Intent(this, LoginActivity::class.java))
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        finish()
    }

    override fun showError(msg: String) {
        showToast(msg)
    }

    override fun setAdapter(notes: List<Note>) {
        mAdapter.updateAdapter(notes)
    }

    override fun clearEdittext() {
        edtNote.setText("")
    }
}
