package com.duke.learnmvp.view.activities.views

import com.duke.learnmvp.data.models.Note

interface MainActivityView {

    fun showLoginActivity()

    fun showError(msg: String)

    fun setAdapter(notes: List<Note>)

    fun clearEdittext()
}