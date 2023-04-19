package com.example.firstapp.todoapp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.R

class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvCaCategoryName: TextView = view.findViewById(R.id.tvCategoryName)
    private val divider: View = view.findViewById(R.id.divider)

    fun render(taskCategory: TaskCategory){
        tvCaCategoryName.text = "EJEMPLO"
    }
}