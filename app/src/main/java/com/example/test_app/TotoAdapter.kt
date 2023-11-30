package com.example.test_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TotoAdapter(
    var todos:List<Todo>
):RecyclerView.Adapter<TotoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val tvTodo: TextView = itemView.findViewById(R.id.tv_todo)
        val checked:CheckBox = itemView.findViewById(R.id.todo_check)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.tvTodo.text = todos[position].title
        holder.checked.isChecked = todos[position].isChecked
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}