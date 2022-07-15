package com.example.messenger.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.messenger.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, ListUserChats()).commit()

    }
}