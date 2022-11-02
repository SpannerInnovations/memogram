package com.example.memogram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBar

class UserHome : AppCompatActivity() {
    lateinit var name : TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_home)

        name = findViewById(R.id.homeusername);
        name.text = intent.getStringExtra("firstname")

        //creating the action bar and show the back arrow
        val actionBar: ActionBar? = supportActionBar
        // calling the action bar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }


    //method called when click on back arrow
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}