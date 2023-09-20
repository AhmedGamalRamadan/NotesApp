package com.ahmed.android.noteapp.noteadapter

import com.ahmed.android.noteapp.R
import com.ahmed.android.noteapp.database.Note
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ahmed.android.noteapp.MainActivity


class NoteRVAdapter(
    val context: Context,
    val noteClickDeleteInterface: MainActivity,
    val noteClickInterface: MainActivity
) :
    RecyclerView.Adapter<NoteRVAdapter.ViewHolder>() {

    private val allNotes = ArrayList<Note>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val noteTV = itemView.findViewById<TextView>(R.id.idTVNote)
        val dateTV = itemView.findViewById<TextView>(R.id.idTVDate)
        val deleteIV = itemView.findViewById<ImageView>(R.id.idIVDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.note_rv_item,
            parent, false
        )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.noteTV.text = allNotes[position].noteTitle
        holder.dateTV.text = allNotes[position].timeStamp
        holder.deleteIV.setOnClickListener {
            noteClickDeleteInterface.onDeleteIconClick(allNotes[position])
        }

        holder.itemView.setOnClickListener {
            noteClickInterface.onNoteClick(allNotes[position])
        }
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }


    fun updateList(newList: List<Note>) {
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }

}

interface NoteClickDeleteInterface {
    fun onDeleteIconClick(note: Note)
}

interface NoteClickInterface {
    fun onNoteClick(note: Note)
}