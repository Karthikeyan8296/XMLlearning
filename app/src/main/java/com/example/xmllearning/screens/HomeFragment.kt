package com.example.xmllearning.screens

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.xmllearning.R

class HomeFragment : Fragment(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<LinearLayout>(R.id.btnHome).setOnClickListener {
            val action =
                HomeFragmentDirections.actionHomeFragmentToUserFragment(name = "karthikeyan")
            findNavController().navigate(action)
        }


//        val fragment = UserFragment()
//
//        val bundle = Bundle()
//        bundle.putString("name", "karthik")
//        fragment.arguments = bundle

        //from fragment to another fragment
//        parentFragmentManager.beginTransaction()
//            .replace(R.id.fragmentContainer, fragment)
//            .addToBackStack(null)
//            .commit()
    }
}