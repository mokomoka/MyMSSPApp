package com.example.mymsspapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val itemThumbnail: ImageView = view.findViewById(R.id.itemThumbnail)
    val itemTitle : TextView = view.findViewById(R.id.itemTitle)
    val itemTime : TextView = view.findViewById(R.id.itemTime)
    val itemViewCounter : TextView = view.findViewById(R.id.itemViewCounter)
    val itemCommentCounter : TextView = view.findViewById(R.id.itemCommentCounter)
}