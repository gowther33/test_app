package com.example.test_app


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.test_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)


        binding.btnSecondActivity.setOnClickListener {
            val name = binding.etName.text.toString()
            val person = User(name, 21, "Staff Engineer")
            Intent(this, SecondActivity::class.java).apply {
                this.putExtra("EXTRA_SERIALIZABLE", person)
                startActivity(this)
            }
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
}