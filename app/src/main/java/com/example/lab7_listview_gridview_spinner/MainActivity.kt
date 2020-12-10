package com.example.lab7_listview_gridview_spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab7_listview_gridview_spinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //在Activity中使用View Binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}