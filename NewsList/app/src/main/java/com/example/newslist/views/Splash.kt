package com.example.newslist.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.newslist.R
import java.util.*

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()
        Timer().schedule(object : TimerTask() {
            override fun run() {
                startActivity(Intent(this@Splash, MainActivity::class.java))
                finish()
            }
        }, 1500)
    }
}