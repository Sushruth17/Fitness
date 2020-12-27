package com.seventeen.fitness.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.seventeen.fitness.R
import kotlinx.android.synthetic.main.unit_story.view.*


class StoryAdapter: RecyclerView.Adapter<StoryAdapter.ViewHolder>(){


        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val count: TextView = itemView.count
        }


    lateinit var data:List<String>
    fun setDataCustom(data: List<String>){
        this.data = data
    }

    lateinit var view : ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
            view = ViewHolder(LayoutInflater.from(parent.context).inflate
                            (R.layout.unit_story, parent, false))
        return view
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val unitData: String = data[position]
        holder.count.text = unitData
    }

}

