package com.seventeen.fitness.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.seventeen.fitness.R
import com.seventeen.fitness.utils.UtilsString
import kotlinx.android.synthetic.main.unit_home_1.view.*


class DashboardAdapter1(val context: Context): RecyclerView.Adapter<DashboardAdapter1.ViewHolder>(){


        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val unitHomeTxt1: TextView = itemView.unit_home_txt1
            val unitRoot: LinearLayout = itemView.unitRoot
        }


    lateinit var data:List<String>
    lateinit var type:String
    fun setDataCustom(data: List<String>,type:String){
        this.data = data
        this.type = type
    }

    lateinit var view : ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        when(type) {
            UtilsString.BEGINNER ->
                view = ViewHolder(LayoutInflater.from(parent.context).inflate
                            (R.layout.unit_home_1, parent, false))
            UtilsString.INTERMEDIATE ->
                view = ViewHolder(LayoutInflater.from(parent.context).inflate
                    (R.layout.unit_home_1, parent, false))
            UtilsString.ADVANCED ->
                view = ViewHolder(LayoutInflater.from(parent.context).inflate
                    (R.layout.unit_home_1, parent, false))
        }
        return view
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val unitData: String = data[position]
        when(type) {
            UtilsString.BEGINNER -> {
                holder.unitRoot.setBackgroundResource(R.drawable.dashboad_ui1)
                holder.unitHomeTxt1.setTextColor(context.resources.getColor(R.color.colorPrimary))

            }
            UtilsString.INTERMEDIATE -> {
                holder.unitRoot.setBackgroundResource(R.drawable.dashboad_ui2)
//                holder.unitHomeTxt1.setTextColor(context.resources.getColor(R.color.colorPrimary))
            }
            UtilsString.ADVANCED -> {
                holder.unitRoot.setBackgroundResource(R.drawable.dashboad_ui1)
                holder.unitHomeTxt1.setTextColor(context.resources.getColor(R.color.colorPrimary))

            }
        }
        holder.unitHomeTxt1.text = unitData
    }

}

