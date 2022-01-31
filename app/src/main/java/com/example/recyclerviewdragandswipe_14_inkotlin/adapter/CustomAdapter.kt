package com.example.recyclerviewdragandswipe_14_inkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdragandswipe_14_inkotlin.R
import com.example.recyclerviewdragandswipe_14_injava.helper.ItemTouchHelperAdapter
import com.example.recyclerviewdragandswipe_14_injava.model.Member

import java.util.*
import kotlin.collections.ArrayList

class CustomAdapter(private val members: ArrayList<Member>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(), ItemTouchHelperAdapter {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_custom_layout, viewGroup, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val  member = members[position]
        if (holder is CustomViewHolder) {
            val first_name = holder.first_name
            val last_name = holder.last_name
            first_name.text = member.firstName
            last_name.text = member.lastName
        }
    }

    override fun getItemCount(): Int {
        return members.size
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(members, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(members, i, i - 1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onItemDismiss(position: Int) {
        members.removeAt(position)
        notifyItemRemoved(position)
    }

    class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view){
           val first_name = view.findViewById<TextView>(R.id.first_name)
           val last_name = view.findViewById<TextView>(R.id.last_name)
    }
}