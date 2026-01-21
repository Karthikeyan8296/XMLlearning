package com.example.xmllearning

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.intellij.lang.annotations.Pattern

const val PASSWORD_PATTERN = """^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!_])(?=\S+$).{8,}$"""

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name = findViewById<EditText>(R.id.etName)
        val email = findViewById<EditText>(R.id.etEmail)
        val password = findViewById<EditText>(R.id.etPassword)
        val btn = findViewById<Button>(R.id.btnContinue)
        val result = findViewById<TextView>(R.id.resultText)

        fun isValidEmail(email: CharSequence): Boolean{
            return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }

        fun isValidPassword(password: String): Boolean{
            return Regex(PASSWORD_PATTERN).matches(password)
        }

        btn.setOnClickListener {
            val name = name.text.toString().trim()
            val email = email.text.toString().trim()
            val password = password.text.toString().trim()
            if(name.isEmpty() || !isValidEmail(email) || !isValidPassword(password)){
                result.text = "Invalid credentials"
                return@setOnClickListener
            }
            else{
                Toast.makeText(applicationContext, "success bro", Toast.LENGTH_SHORT).show()
                Log.d("SIGN", "this is what you typed, name: $name | email: $email | password: $password")
                result.text = "You typed: \nname: $name\nemail: $email\npassword: $password"
            }
        }
    }
}