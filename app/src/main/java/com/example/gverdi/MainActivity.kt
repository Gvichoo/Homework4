package com.example.gverdi

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val username = findViewById<EditText>(R.id.username)
        val email = findViewById<EditText>(R.id.email)
        val firstname = findViewById<EditText>(R.id.firstname)
        val lastname = findViewById<EditText>(R.id.lastname)
        val age = findViewById<EditText>(R.id.age)
        val saveBtn = findViewById<Button>(R.id.saveButton)
        val clearBtn = findViewById<Button>(R.id.clearButton)

        saveBtn.setOnClickListener {
            if (validate(username, email, age)) {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("username", username.text.toString())
                intent.putExtra("email", email.text.toString())
                intent.putExtra("firstname", firstname.text.toString())
                intent.putExtra("lastname", lastname.text.toString())
                intent.putExtra("age", age.text.toString())
                username.text.clear()
                email.text.clear()
                firstname.text.clear()
                lastname.text.clear()
                age.text.clear()
                startActivity(intent)
            }
        }

        clearBtn.setOnLongClickListener {
            username.text.clear()
            email.text.clear()
            firstname.text.clear()
            lastname.text.clear()
            age.text.clear()
            true
        }

    }


     private fun validateUsername(username: EditText): Boolean {
        if (username.text.isEmpty() || username.text.length < 10) {
            Toast.makeText(this,"Username should be at least 10 characters long.",Toast.LENGTH_LONG).show()
            return false
        }
         return true
    }
    private fun validateEmail(email : EditText):Boolean {
        if (!Patterns.EMAIL_ADDRESS.matcher(email.text).matches()) {
            Toast.makeText(this, "Please enter a valid email address.", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }
    private fun validateAge(age : EditText):Boolean{
        if (age.text.isEmpty() || age.text.toString().toInt() <= 0) {
            Toast.makeText(this, "Age  should be a positive number.", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }
    private fun validate(username: EditText,email: EditText,age: EditText):Boolean{
        return validateUsername(username) && validateAge(age) && validateEmail(email)
    }

}
