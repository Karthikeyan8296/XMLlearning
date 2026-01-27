package com.example.xmllearning.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xmllearning.R
import com.example.xmllearning.components.HetroAdaptor
import com.example.xmllearning.components.HetroItems
import com.example.xmllearning.components.RoomModel

class HetroFragment : Fragment(R.layout.fragment_hetro) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val info = listOf(
            HetroItems.Header(title = "Your rooms!"),
            HetroItems.Room(
                RoomModel("Bedroom", "23", "2", R.drawable.flash, R.drawable.bed)
            ),
            HetroItems.Room(
                RoomModel("Bathroom", "23", "2", R.drawable.flash, R.drawable.bed)
            ),
            HetroItems.Room(
                RoomModel("Kitchen", "23", "2", R.drawable.flash, R.drawable.bed)
            ),
            HetroItems.Footer
        )

        val recycle = view.findViewById<RecyclerView>(R.id.hetroRecycleView)

        recycle.layoutManager = LinearLayoutManager(requireContext())
        recycle.adapter = HetroAdaptor(info)
    }




}