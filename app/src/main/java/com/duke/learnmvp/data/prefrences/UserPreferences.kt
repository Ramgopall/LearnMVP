package com.duke.learnmvp.data.prefrences

import androidx.annotation.Keep
import com.duke.learnmvp.data.models.Note

@Keep
interface UserPreferences {

    val IS_USER_LOGIN: String
        get() = "isUserLogin"
    val NOTES_LIST: String
        get() = "notes_list"

    fun setUserLogin(status: Boolean)

    fun isUserLogin(): Boolean?

    fun addNote(note: Note)

    fun getNotes(): List<Note>

    fun clearUser()

    fun removeNote(note: Note)
}