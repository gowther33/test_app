package com.example.test_app
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.test_app.databinding.ItemViewBinding

class TotoAdapter(
    var todos:List<Todo>,
    val listener: OnItemClickListener
):RecyclerView.Adapter<TotoAdapter.TodoViewHolder>() {

    // Without inner keyword this is equivalent of a static class member
    inner class TodoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),
    OnClickListener{
        val textView = itemView.findViewById<TextView>(R.id.tv_todo)
        val todoCheck = itemView.findViewById<CheckBox>(R.id.todo_check)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position  != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view,
        parent,
        false
        )
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val item = todos[position]
        holder.textView.text = item.title
        holder.todoCheck.isChecked = item.isChecked

    }

    override fun getItemCount(): Int {
        return todos.size
    }

    interface OnItemClickListener{
        fun onItemClick(position:Int)
    }

}