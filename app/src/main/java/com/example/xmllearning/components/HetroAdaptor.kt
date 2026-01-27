package com.example.xmllearning.components

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.xmllearning.R

sealed class HetroItems {
    data class Header(val title: String): HetroItems()
    data class Room(val data: RoomModel): HetroItems()
    data object Footer: HetroItems()
}

class HeaderViewHolder(view: View): RecyclerView.ViewHolder(view){
    val name: TextView = view.findViewById(R.id.header_card_Id)
}

class RoomViewHolder(view: View): RecyclerView.ViewHolder(view){
    val bgImage: ImageView = view.findViewById(R.id.roomBgImage)
    val roomIcon: ImageView = view.findViewById(R.id.roomIconType)
    val onCount: TextView = view.findViewById(R.id.roomOn)
    val device: TextView = view.findViewById(R.id.roomDevices)
    val roomName: TextView = view.findViewById(R.id.roomTypeName)
}

class FooterViewHolder(view: View): RecyclerView.ViewHolder(view)

class HetroAdaptor(private val items: List<HetroItems>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    companion object {
        const val TYPE_HEADER = 0
        const val TYPE_ROOM = 1
        const val TYPE_FOOTER = 2
    }

    override fun getItemViewType(position: Int): Int {
        return when(items[position]){
            is HetroItems.Header -> TYPE_HEADER
            is HetroItems.Room -> TYPE_ROOM
            is HetroItems.Footer -> TYPE_FOOTER
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when(viewType){
            TYPE_HEADER -> HeaderViewHolder(
                inflater.inflate(R.layout.header_card,  parent, false)
            )
            TYPE_ROOM -> RoomViewHolder(
                inflater.inflate(R.layout.room_card, parent, false)
            )
            else -> FooterViewHolder(
                inflater.inflate(R.layout.footer_card, parent, false)
            )
        }
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        when(val item = items[position]){
            is HetroItems.Header -> {
                val main = holder as HeaderViewHolder
                main.name.text = item.title
            }
            is HetroItems.Room -> {
                val main = holder as RoomViewHolder
                main.bgImage.setImageResource(item.data.roomBg)
                main.device.text = item.data.device
                main.roomIcon.setImageResource(item.data.roomIcon)
                main.onCount.text = item.data.onCount
                main.roomName.text = item.data.roomName
            }
            is HetroItems.Footer -> {
                //We can pass any clickable events over here!
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}