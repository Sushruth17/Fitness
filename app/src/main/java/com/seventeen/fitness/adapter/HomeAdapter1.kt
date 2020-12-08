package com.seventeen.fitness.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.seventeen.fitness.R
import kotlinx.android.synthetic.main.unit_home_1.view.*


class HomeAdapter1: RecyclerView.Adapter<HomeAdapter1.ViewHolder>(){


        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val unitHomeTxt1: TextView = itemView.unit_home_txt1
        }


    lateinit var data:List<String>
    fun setDataCustom(data: List<String>){
        this.data = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate
                (R.layout.unit_home_1, parent, false)
        )

    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val unitData: String? = data[position]
        if (unitData != null) {
            holder.unitHomeTxt1.text = unitData

        }
    }

}

