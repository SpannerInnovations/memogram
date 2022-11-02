package com.example.memogram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val topscreenimage : ImageView = findViewById(R.id.topscreenimage);
        val firstName : EditText = findViewById(R.id.username);
        val passwordEditText : EditText = findViewById(R.id.password);
        passwordEditText.transformationMethod = AsteriskTransformationMethod();
        Glide.with(this).load(R.drawable.nebulous).into(topscreenimage)



        fun enterBtn(view: View) {
            val intent = Intent(this@MainActivity,UserHome::class.java)
            intent.putExtra("firstname", firstName.text.toString());
            startActivity(intent)
        }

    }
}