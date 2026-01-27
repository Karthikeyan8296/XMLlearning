package com.example.xmllearning.components

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.xmllearning.R

class RoomAdaptor(private val roomItem: List<RoomModel>): RecyclerView.Adapter<RoomAdaptor.RoomViewHolder>() {

    //one row of items are listed here
    class RoomViewHolder(view: View): RecyclerView.ViewHolder(view){
        val bgImage: ImageView = view.findViewById(R.id.roomBgImage)
        val roomIcon: ImageView = view.findViewById(R.id.roomIconType)
        val onCount: TextView = view.findViewById(R.id.roomOn)
        val device: TextView = view.findViewById(R.id.roomDevices)
        val roomName: TextView = view.findViewById(R.id.roomTypeName)
    }

    //use the viewHolder, when u create an new row
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RoomViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.room_card, parent, false)

        return RoomViewHolder(view)
    }

    //here the actual mapping happens
    override fun onBindViewHolder(
        holder: RoomViewHolder,
        position: Int
    ) {
        val room = roomItem[position]
        holder.bgImage.setImageResource(room.roomBg)
        holder.roomIcon.setImageResource(room.roomIcon)
        holder.device.text = room.device
        holder.onCount.text = room.onCount
        holder.roomName.text = room.roomName
    }

    override fun getItemCount(): Int {
        return roomItem.size
    }
}


data class RoomModel(
    val roomName: String,
    val device: String,
    val onCount: String,
    val roomIcon: Int,
    val roomBg: Int
)