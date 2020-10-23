package com.example.bottomnav

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.bottomnav.Fragment.TimeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val controller = Navigation.findNavController(this,R.id.nav_host_fragment)
        NavigationUI.setupWithNavController(bottomNavigationView,controller)
    }
}

