package com.ahmed.android.noteapp.repo

import androidx.lifecycle.LiveData
import com.ahmed.android.noteapp.database.Note
import com.ahmed.android.noteapp.database.NotesDao


class NoteRepository(private val notesDao: NotesDao) {


    val allNotes: LiveData<List<Note>> = notesDao.getAllNotes()

    suspend fun insert(note: Note) {
        notesDao.insert(note)
    }
    suspend fun delete(note: Note){
        notesDao.delete(note)
    }

    suspend fun update(note: Note){
        notesDao.update(note)
    }
}