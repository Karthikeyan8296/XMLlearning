package com.example.xmllearning.screens

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.xmllearning.R

class HomeFragment : Fragment(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<LinearLayout>(R.id.btnHome).setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToUserFragment(name= "karthikeyan")
            findNavController().navigate(action)
        }
    }
}