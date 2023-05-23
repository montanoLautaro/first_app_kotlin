package com.example.firstapp.todoapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.R
import com.example.firstapp.databinding.ActivityTodoBinding

class TodoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTodoBinding
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var taskAdapter: TaskAdapter
    private val categories = listOf(
        TaskCategory.Business,
        TaskCategory.Other,
        TaskCategory.Personal
    )

    private val tasks = mutableListOf(
        Task("PruebaBusiness", TaskCategory.Business),
        Task("PruebaPersonal", TaskCategory.Business),
        Task("PruebaOther", TaskCategory.Business)


    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUi()
        initListeners()
    }

    private fun initListeners() {
        binding.fabAddTask.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)

        val btnAddTask: Button = dialog.findViewById(R.id.btnAddTask)
        val etTask: EditText = dialog.findViewById(R.id.etTask)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddTask.setOnClickListener {
            val currentTask = etTask.text.toString()
            if (currentTask.isNotEmpty()) {
                val selectedID = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedID)
                val currentCategory: TaskCategory = when (selectedRadioButton.text) {
                    getString(R.string.todo_category_business) -> TaskCategory.Business
                    getString(R.string.todo_category_personal) -> TaskCategory.Personal
                    else -> TaskCategory.Other
                }

                tasks.add(Task(currentTask, currentCategory))
                updateTasks()
                dialog.hide()
            }

        }

        dialog.show()
    }

    private fun initUi() {
        // RECYCLERVIEW 1
        // con funcion lambda opcion 2
        categoriesAdapter = CategoriesAdapter(categories) { position -> updateCategories(position) }
        // el recylcerview de forma horizontal
        binding.rvCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        // seteamos el adapter del recyclerview
        binding.rvCategories.adapter = categoriesAdapter

        // RECYCLERVIEW 2
        // con funcion lambda opcion 1
        taskAdapter = TaskAdapter(tasks, { onItemSelected(it) })
        // el recylcerview de forma horizontal, es el por defecto
        binding.rvTasks.layoutManager = LinearLayoutManager(this)
        binding.rvTasks.adapter = taskAdapter

    }

    private fun updateCategories(position: Int) {
        categories[position].isSelected = !categories[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        updateTasks()
    }

    private fun onItemSelected(position: Int) {
        tasks[position].isSelected = !tasks[position].isSelected
    }

    private fun updateTasks() {
        val selectedCategories: List<TaskCategory> = categories.filter { it.isSelected }
        val newTasks = tasks.filter { selectedCategories.contains(it.category) }
        taskAdapter.tasks = newTasks
        taskAdapter.notifyDataSetChanged()
    }
}