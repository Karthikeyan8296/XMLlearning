package com.example.xmllearning.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.xmllearning.R

class WelcomeFragment : Fragment(R.layout.fragment_welcome) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnNext = view.findViewById<View>(R.id.btnNext)

        btnNext.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fragmentContainer, HomeFragment())
                .addToBackStack(null).commit()
        }
    }
}