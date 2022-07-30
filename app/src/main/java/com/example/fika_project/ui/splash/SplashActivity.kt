package com.example.fika_project.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.fika_project.databinding.ActivitySplashBinding
import com.example.fika_project.ui.login.LoginActivity

class SplashActivity : AppCompatActivity(){
    lateinit var binding : ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent= Intent(this, LoginActivity::class.java)
            startActivity(intent)
        },200)
    }
}