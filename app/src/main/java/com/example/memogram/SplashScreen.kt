package com.example.memogram

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

@Suppress("DEPRECATION")
class SplashScreen : AppCompatActivity() {
    lateinit var logo: ImageView;
    lateinit var flowers : ImageView;
    lateinit var boomers : ImageView;
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
//
        logo = findViewById(R.id.SplashScreenImage)
        flowers = findViewById(R.id.flowersimg)
        boomers = findViewById(R.id.boomersimg)

        // This is used to hide the status bar and make
        // the splash screen as a full screen activity.
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        Glide.with(this).load(R.drawable.memogram).into(logo)
        Glide.with(this).load(R.drawable.flowers).into(flowers)
        Glide.with(this).load(R.drawable.boomers).into(boomers)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000) // 3000 is the delayed time in milliseconds.
    }
}