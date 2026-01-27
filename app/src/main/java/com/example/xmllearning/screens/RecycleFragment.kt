package com.example.xmllearning.screens

import android.graphics.Rect
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xmllearning.R
import com.example.xmllearning.components.MyAdaptor
import com.example.xmllearning.components.RoomAdaptor
import com.example.xmllearning.components.RoomModel

class RecycleFragment : Fragment(R.layout.fragment_recycle) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = listOf("karthik", "padmesh", "varsha", "John")

        val recycleView = view.findViewById<RecyclerView>(R.id.recycle)

        recycleView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        recycleView.adapter = MyAdaptor(data)


        //Room card recycleView
        val roomData = listOf<RoomModel>(
            RoomModel(
                roomName = "Bedroom",
                device = "5 Devices",
                onCount = "3 On",
                roomIcon = R.drawable.office_icon,
                roomBg = R.drawable.bed
            ),
            RoomModel(
                roomName = "Bathroom",
                device = "2 Devices",
                onCount = "3 On",
                roomIcon = R.drawable.office_icon,
                roomBg = R.drawable.bed
            ),
        )

        val roomRecycleView = view.findViewById<RecyclerView>(R.id.roomRecycleView)
        roomRecycleView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        roomRecycleView.adapter = RoomAdaptor(roomData)

        roomRecycleView.addItemDecoration(
            object : RecyclerView.ItemDecoration(){
                override fun getItemOffsets(
                    outRect: Rect,
                    view: View,
                    parent: RecyclerView,
                    state: RecyclerView.State
                ) {
                    outRect.right = 52
                }
            }
        )
    }
}
