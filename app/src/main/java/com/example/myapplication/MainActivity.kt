package com.example.myapplication

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding


private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupSpinerBasic()
    }

    private fun setupSpinerBasic() {
//        val list = resources.getStringArray(R.array.languages)
        //-> khơi tạo list từ mảng string trong file string.xml


         val list = mutableListOf<String>() //khởi tạo mutableList

        list.add("English")
        list.add("Vietnamese")
        list.add("Chinese")

        val adt = ArrayAdapter(this, android.R.layout.simple_spinner_item, list)


        binding.spLanguage.adapter=adt

    }
}