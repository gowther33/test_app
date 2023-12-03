package com.example.test_app


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), TotoAdapter.OnItemClickListener  {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        var todos = mutableListOf<Todo>(
            Todo("Check how to send notification", false),
            Todo("Check Services", false)
        )


        val adapter = TotoAdapter(todos, this)
        binding.rvTodos.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvTodos.adapter = adapter


        binding.btnAdd.setOnClickListener {
            val title =  binding.etName.text.toString()
            val todo = Todo(title, false)
            todos.add(todo)
            adapter.notifyItemInserted(todos.size-1)
        }


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.it_home -> Toast.makeText(this, "Home Button Clicked", Toast.LENGTH_SHORT).show()
            R.id.it_list -> Toast.makeText(this, "List Button Clicked", Toast.LENGTH_SHORT).show()
            R.id.it_grid -> Toast.makeText(this, "Grid Button Clicked", Toast.LENGTH_SHORT).show()
        }
        return true
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item at position: $position clicked", Toast.LENGTH_SHORT).show()
    }
}