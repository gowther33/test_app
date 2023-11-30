package com.example.test_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test_app.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val person = intent.getSerializableExtra("EXTRA_SERIALIZABLE") as User
        binding.tvAct2.text = "Welcome ${person.name}: ${person.age}: ${person.role} to second activity "

        binding.btnFirstActivity.setOnClickListener {
            finish()
        }

    }
}