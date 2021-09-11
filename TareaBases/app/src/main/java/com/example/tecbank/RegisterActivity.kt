package com.example.tecbank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val registerButtonAction = findViewById<Button>(R.id.buttonRegisterRegister)
        registerButtonAction.setOnClickListener {

            val Intent = Intent(this, LoginActivity::class.java)
            startActivity(Intent)

        }

    }
}