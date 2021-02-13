package com.example.mytaxiw.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mytaxiw.MainActivity
import com.example.mytaxiw.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        GlobalScope.launch {
            delay(1000)
            intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
            finish()
        }



    }

}