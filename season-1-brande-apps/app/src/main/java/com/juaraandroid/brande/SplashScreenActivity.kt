package com.juaraandroid.brande

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.juaraandroid.brande.databinding.ActivitySplashScreenBinding

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    private lateinit var activitySplashScreenBinding: ActivitySplashScreenBinding
    private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        activitySplashScreenBinding = ActivitySplashScreenBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(activitySplashScreenBinding.root)

        handler = Handler()
        handler.postDelayed({
            Intent(this, HomeActivity::class.java).apply {
                startActivity(this)
                finish()
            }
        }, 3500)
    }
}