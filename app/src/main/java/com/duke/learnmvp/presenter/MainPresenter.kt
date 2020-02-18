package com.duke.learnmvp.presenter

import android.content.Intent
import android.text.TextUtils
import com.duke.learnmvp.data.models.Note
import com.duke.learnmvp.data.prefrences.UserPreferences
import com.duke.learnmvp.data.prefrences.UserPreferencesImpl
import com.duke.learnmvp.presenter.Adapters.NotesAdapter
import com.duke.learnmvp.view.activities.views.MainActivityView

import java.text.SimpleDateFormat
import java.util.Date

class MainPresenter(private val mView: MainActivityView) : AbstractPresenter(), NotesAdapter.NoteDeleteListener {

    private var mDatabase: UserPreferences = UserPreferencesImpl()
    private var simpleDateFormat = SimpleDateFormat("dd/MM/yyy hh:mm a")

    fun onCreate(intent: Intent) {
        mView.setAdapter(mDatabase.getNotes())
    }

    fun addNote(note: String) {
        if (TextUtils.isEmpty(note)) {
            mView.showError("Please add few words for note.")
        } else {
            mDatabase.addNote(Note(System.currentTimeMillis(), note, simpleDateFormat.format(Date())))
            mView.setAdapter(mDatabase.getNotes())
            mView.clearEdittext()
        }
    }

    override fun onNoteDeleteClicked(note: Note) {
        mDatabase.removeNote(note)
        //        mView.setAdapter(mDatabase.getNotes());
    }

    fun logoutApp() {
        mDatabase.clearUser()
        mView.showLoginActivity()
    }
}
