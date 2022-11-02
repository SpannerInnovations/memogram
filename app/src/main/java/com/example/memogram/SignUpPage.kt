package com.example.memogram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast


class SignUpPage : AppCompatActivity() {

    lateinit var textFName : EditText
    lateinit var textLName: EditText
    lateinit var textEmail: EditText
    lateinit var textPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_page)

        textFName = findViewById(R.id.editTextFirstName)
        textLName = findViewById(R.id.editTextLastName)
        textEmail = findViewById(R.id.editTextEmail)
        textPassword = findViewById(R.id.editTextPassword)
    }

    fun joinClick(view: View?){
        val fname:String = textFName.text.toString()
        val lname:String = textLName.text.toString()
        val email:String = textEmail.text.toString()
        val password:String = textPassword.text.toString()

        val bundle = Bundle()
        bundle.putString("key1",fname)
        bundle.putString("key2",lname)
        bundle.putString("key3",email)
        bundle.putString("key4",password)

        val intent = Intent(this,MainActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)

        Toast.makeText(baseContext,"Welcome to Memogram $fname", Toast.LENGTH_LONG).show()

    }






}