package com.example.xmllearning.screens

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.xmllearning.R
import com.example.xmllearning.utils.PASSWORD_PATTERN

class UserFragment : Fragment(R.layout.fragment_user) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: UserFragmentArgs by navArgs()
        val username = args.name

        val name = view.findViewById<EditText>(R.id.etName)
        val email = view.findViewById<EditText>(R.id.etEmail)
        val password = view.findViewById<EditText>(R.id.etPassword)
        val btn = view.findViewById<Button>(R.id.btnContinue)
        val result = view.findViewById<TextView>(R.id.resultText)
        var user = view.findViewById<TextView>(R.id.username)

        user.text = username

        fun isValidEmail(email: CharSequence): Boolean {
            return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }

        fun isValidPassword(password: String): Boolean {
            return Regex(PASSWORD_PATTERN).matches(password)
        }

        btn.setOnClickListener {
            val name = name.text.toString().trim()
            val email = email.text.toString().trim()
            val password = password.text.toString().trim()
            if (name.isEmpty() || !isValidEmail(email) || !isValidPassword(password)) {
                result.text = "Invalid credentials"
                return@setOnClickListener
            } else {
                Toast.makeText(context, "success bro", Toast.LENGTH_SHORT).show()
                Log.d(
                    "SIGN",
                    "this is what you typed, name: $name | email: $email | password: $password"
                )
                result.text = "You typed: \nname: $name\nemail: $email\npassword: $password"

                findNavController().navigate(R.id.action_userFragment_to_recycleFragment)
            }
        }
    }
}