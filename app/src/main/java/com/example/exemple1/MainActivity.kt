package com.example.exemple1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exemple1.adapter.PersonAdapter
import com.example.exemple1.databinding.ActivityMainBinding
import com.example.exemple1.model.Person

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterbinding: PersonAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val person1 = Person(1, "ala")
        val person2 = Person(2, "3abdennacer")
        val person3 = Person(3, "Amine")
        val last = arrayListOf<Person>(person1, person2, person3)
        adapterbinding = PersonAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        with(binding) {
            recyclerView.adapter = adapterbinding
            adapterbinding.setData(last)
        }

        binding.button.setOnClickListener {
            // Handle item click
            val person4 = Person(4, "AHMED")
            last.add(person4)
            adapterbinding.setData(last)
        }

    }
}