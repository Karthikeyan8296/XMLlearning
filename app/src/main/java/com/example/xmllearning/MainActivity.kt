package com.example.xmllearning

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    fun showToast(value: String) {
        Toast.makeText(applicationContext, value, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //edgeToEdge is draw behind the system bars
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        showToast("OnCreate")

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<LinearLayout>(R.id.btnNext).setOnClickListener {
            val intent = Intent(applicationContext, MainActivity2::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        showToast("OnStart")
    }

    override fun onResume() {
        super.onResume()
        showToast("OnResume")
    }

    override fun onPause() {
        super.onPause()
        showToast("OnPause")
    }

    override fun onStop() {
        super.onStop()
        showToast("OnStop")
    }

    override fun onRestart() {
        super.onRestart()
        showToast("onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        showToast("OnDestroy")
    }
}