package com.example.messenger.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI

import com.example.messenger.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    lateinit var bottomNavigationBar: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = Navigation.findNavController(this,R.id.nav_host_fragment)
        bottomNavigationBar = findViewById(R.id.bottomNavBar)
        NavigationUI.setupWithNavController(bottomNavigationBar, navController)

    }
    private val listener = NavController.OnDestinationChangedListener { controller, destination, arguments ->

        if ((destination.id!=R.id.loginFragment)&&(destination.id!=R.id.registerFragment)&&(destination.id!=R.id.chatFragment))
            bottomNavigationBar.visibility=View.VISIBLE
        else
            bottomNavigationBar.visibility=View.GONE

    }
    override fun onResume() {
        super.onResume()
        navController.addOnDestinationChangedListener(listener)
    }

    override fun onPause() {
        navController.removeOnDestinationChangedListener(listener)
        super.onPause()
    }
}