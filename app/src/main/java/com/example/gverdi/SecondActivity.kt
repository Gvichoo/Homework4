package com.example.gverdi

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val email1 = findViewById<TextView>(R.id.email1)
        val username1 = findViewById<TextView>(R.id.userName1)
        val fullName1 = findViewById<TextView>(R.id.fullName)
        val age1 = findViewById<TextView>(R.id.age)
        val againButton = findViewById<Button>(R.id.againButton)

        val username = intent.getStringExtra("username")
        val email = intent.getStringExtra("email")
        val firstname = intent.getStringExtra("firstname")
        val lastname = intent.getStringExtra("lastname")
        val age = intent.getStringExtra("age")

        email1.text = "Email: $email"
        username1.text = "Username: $username"
        fullName1.text = "Full Name: $firstname $lastname"
        age1.text = "Age: $age"

        againButton.setOnClickListener {
            finish()
        }
    }
}
