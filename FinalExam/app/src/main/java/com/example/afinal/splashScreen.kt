package com.example.afinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Handler
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_splash_screen.*
class splashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        splash_logo.setImageResource(R.drawable.spalsh_logo)

        val SPLASH_TIME_OUT = 3000
        val homeIntent = Intent(this@splashScreen, login::class.java)
        Handler().postDelayed({
            startActivity(homeIntent)
            finish()
        }, SPLASH_TIME_OUT.toLong())
    }
}
