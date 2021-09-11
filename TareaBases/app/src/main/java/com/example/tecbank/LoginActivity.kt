package com.example.tecbank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginButtonAction = findViewById<Button>(R.id.buttonLoginLogin)
        loginButtonAction.setOnClickListener {

            val Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)

        }

        val registerButtonAction = findViewById<Button>(R.id.buttonLoginRegister)
        registerButtonAction.setOnClickListener {

            val Intent = Intent(this, RegisterActivity::class.java)
            startActivity(Intent)

        }



    }
}