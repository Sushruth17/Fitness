package com.seventeen.fitness

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.seventeen.fitness.utils.PrefUtils
import com.seventeen.fitness.utils.UtilsString

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        val backgroundImage: ImageView = findViewById(R.id.SplashScreenImage)
        val slideAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        backgroundImage.startAnimation(slideAnimation)

        val isLoggedIn = PrefUtils.getValueBoolean(this, UtilsString.LOGGED_IN, false)
        Handler(Looper.getMainLooper()).postDelayed({
            if (isLoggedIn) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
                startActivity(Intent(this, Login::class.java))
                finish()
            }
        }, 2000)
    }
}