package com.example.xmllearning.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xmllearning.R
import com.example.xmllearning.components.MyAdaptor

class RecycleFragment : Fragment(R.layout.fragment_recycle) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = listOf<String>("karthik", "padmesh", "varsha", "John")

        val recycleView = view.findViewById<RecyclerView>(R.id.recycle)

        recycleView.layoutManager = LinearLayoutManager(requireContext())

        recycleView.adapter = MyAdaptor(data)
    }
}
