package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = TodoAdapter()
        listRecyclerView = binding.listRecyclerView
        listRecyclerView.layoutManager = LinearLayoutManager(this)
        listRecyclerView.adapter = adapter
        listRecyclerView.setHasFixedSize(true)

        val btnAddTodo = binding.btnAddTodo
        btnAddTodo.setOnClickListener {
            val task = binding.txtItem.text.toString()
            todoList.add(Todo(task))
            binding.txtItem.setText("")
            adapter.notifyDataSetChanged()
        }

    }
}