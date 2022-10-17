package com.example.numberlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.practice.R

class MainAdapter: RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private val list = (1).rangeTo(20).toList()

    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val button = view.findViewById<Button>(R.id.view_btn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = list[position]
        holder.button.text = item.toString()
        holder.button.setOnClickListener {
//            val context = holder.itemView.context
//            val intentHello = Intent(context, HelloActivity::class.java)
//            context.startActivity(intentHello)

            holder.itemView.findNavController().navigate(R.id.helloFragment)

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}