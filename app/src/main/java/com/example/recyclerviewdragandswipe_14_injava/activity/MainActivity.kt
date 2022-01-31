package com.example.recyclerviewdragandswipe_14_injava.activity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdragandswipe_14_inkotlin.R
import com.example.recyclerviewdragandswipe_14_inkotlin.adapter.CustomAdapter
import com.example.recyclerviewdragandswipe_14_injava.helper.SimpleItemTouchHelperCallback
import com.example.recyclerviewdragandswipe_14_injava.model.Member

import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private val context: Context? = null
    private var recyclerView: RecyclerView? = null

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        val members = prepareMemberList()
        refreshAdapter(members)
    }

    private fun prepareMemberList(): ArrayList<Member> {
        val members = ArrayList<Member>()
        for (i in 0..29) {
            members.add(Member("Ilhombek$i", "Ubaydullayev$i"))
        }
        return members
    }

    private fun refreshAdapter(members: ArrayList<Member>) {
        val adapter = CustomAdapter(members)
        recyclerView!!.setAdapter(adapter)
        val callback: ItemTouchHelper.Callback = SimpleItemTouchHelperCallback(adapter)
        val touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(recyclerView)
    }

    private fun initView() {
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView!!.layoutManager = GridLayoutManager(this, 1)
    }
}