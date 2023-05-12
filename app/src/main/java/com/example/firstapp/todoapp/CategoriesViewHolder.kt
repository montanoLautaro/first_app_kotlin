package com.example.firstapp.todoapp

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.R

class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvCaCategoryName: TextView = view.findViewById(R.id.tvCategoryName)
    private val divider: View = view.findViewById(R.id.divider)
    private val viewCointainer: CardView = view.findViewById(R.id.viewCointainer)

    fun render(taskCategory: TaskCategory, onItemSelected: (Int) -> Unit){
        tvCaCategoryName.text = "EJEMPLO"

        itemView.setOnClickListener{
            //forma 2 , no tan recomendada de usar funciones lambda con recyclerview
            onItemSelected(layoutPosition)
        }


        val color = if(taskCategory.isSelected){
            R.color.todo_background_card
        }else{
            R.color.todo_background_disabled
        }

        viewCointainer.setCardBackgroundColor(ContextCompat.getColor(viewCointainer.context, color))


        when(taskCategory){
            TaskCategory.Business -> {
                tvCaCategoryName.text = "Negocios"
                divider.setBackgroundColor(ContextCompat.getColor(divider.context, R.color.todo_business_category))
            }
            TaskCategory.Other -> {
                tvCaCategoryName.text = "Otros"
                divider.setBackgroundColor(ContextCompat.getColor(divider.context, R.color.todo_other_category))
            }
            TaskCategory.Personal -> {
                tvCaCategoryName.text = "Personal"
                divider.setBackgroundColor(ContextCompat.getColor(divider.context, R.color.todo_personal_category))

            }
        }
    }
}