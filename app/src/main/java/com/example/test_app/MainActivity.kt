package com.example.test_app


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
}