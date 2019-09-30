package com.example.mymsspapp

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_nico -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, NiconicoFragment())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
//                textMessage.setText(R.string.title_dashboard)
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, YoutubeFragment())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
//                textMessage.setText(R.string.title_notifications)
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, FavoriteFragment())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

//        textMessage = findViewById(R.id.message)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, NiconicoFragment())
            .commit()
    }
}
