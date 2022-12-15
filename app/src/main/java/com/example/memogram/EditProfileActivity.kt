package com.example.memogram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class EditProfileActivity : AppCompatActivity() {

    lateinit var textFName : EditText
    lateinit var textLName: EditText
    lateinit var userName: EditText
    lateinit var textEmail: EditText
    lateinit var textPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        textFName = findViewById(R.id.editTextFirstName2)
        textLName = findViewById(R.id.editTextLastName2)
        userName = findViewById(R.id.editTextUsername2)
        textEmail = findViewById(R.id.editTextEmail2)
        textPassword = findViewById(R.id.editTextPassword2)

    }

    fun joinClick(view: View?){
        val fname:String = textFName.text.toString()
        val lname:String = textLName.text.toString()
        val uname:String = userName.text.toString()
        val email:String = textEmail.text.toString()
        val password:String = textPassword.text.toString()


        val bundle = Bundle()
        bundle.putString("firstname2",fname)
        bundle.putString("lastname2",lname)
        bundle.putString("username",uname)
        bundle.putString("email",email)
        bundle.putString("password",password)


        val intent = Intent(this@EditProfileActivity, UserHomeJFG::class.java)
        intent.putExtras(bundle)
        startActivity(intent)

        Toast.makeText(baseContext,"Saved successfully $fname! AKA:$uname ", Toast.LENGTH_LONG).show()

    }
}