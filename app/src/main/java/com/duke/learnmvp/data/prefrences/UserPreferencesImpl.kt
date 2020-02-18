package com.duke.learnmvp.data.prefrences

import android.content.SharedPreferences
import android.text.TextUtils
import com.duke.learnmvp.data.models.Note
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.ArrayList

class UserPreferencesImpl : UserPreferences {

    private var mPreferences: SharedPreferences? = PreferencesProvider.providePreferences()

    override fun isUserLogin(): Boolean? {
        return mPreferences?.getBoolean(IS_USER_LOGIN, false)
    }

    override fun setUserLogin(status: Boolean) {
        mPreferences?.edit()?.putBoolean(IS_USER_LOGIN, status)?.apply()
    }

    override fun addNote(note: Note) {

        val dbNotes = getNotes()
        dbNotes.add(0, note)

        val noteAsString = Gson().toJson(dbNotes)
        mPreferences?.edit()?.putString(NOTES_LIST, noteAsString)?.apply()
    }

    override fun removeNote(note: Note) {

        val dbNotes = getNotes()
        for (i in dbNotes.indices) {
            if (dbNotes[i].id == note.id) {
                dbNotes.removeAt(i)
                break
            }
        }

        if (dbNotes.size > 0) {
            val noteAsString = Gson().toJson(dbNotes)
            mPreferences?.edit()?.putString(NOTES_LIST, noteAsString)?.apply()
        } else {
            mPreferences?.edit()?.putString(NOTES_LIST, "")?.apply()
        }
    }

    override fun getNotes(): ArrayList<Note> {

        var notes = ArrayList<Note>()

        val noteListString = mPreferences?.getString(NOTES_LIST, "")
        if (!TextUtils.isEmpty(noteListString)) {
            notes = Gson().fromJson(noteListString, object : TypeToken<List<Note>>() {

            }.type)
        }

        return notes

    }

    override fun clearUser() {
        mPreferences?.edit()
            ?.putBoolean(IS_USER_LOGIN, false)
            ?.putString(NOTES_LIST, "")
            ?.apply()
    }

}