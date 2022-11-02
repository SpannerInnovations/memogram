package com.example.memogram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    lateinit var firstName : EditText;
    lateinit var topscreenimage : ImageView;
    lateinit var passwordEditText : EditText;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        topscreenimage = findViewById(R.id.topscreenimage);
        Glide.with(this).load(R.drawable.nebulous).into(topscreenimage);

        firstName  = findViewById(R.id.username);
        passwordEditText   = findViewById(R.id.password);
        passwordEditText.transformationMethod = AsteriskTransformationMethod();

    }

    fun loginBtn(view: View) {
        val intent = Intent(this@MainActivity,UserHome::class.java)
        intent.putExtra("firstname", firstName.text.toString());
        startActivity(intent)
    }
}