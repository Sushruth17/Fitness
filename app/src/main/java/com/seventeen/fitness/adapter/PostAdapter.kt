package com.seventeen.fitness.adapter

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.seventeen.fitness.R
import com.seventeen.fitness.model.Post
import com.seventeen.fitness.utils.DoubleClickListener
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

class PostAdapter(
    private val context: Context,
    private val postList: ArrayList<Post>
)
    : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    var liked: Boolean = false
    private var saved: Boolean = false


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.unit_post, parent, false
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val popAnim = AnimationUtils.loadAnimation(context, R.anim.pop)

        holder.name.text = postList[position].name
        holder.likes.text = postList[position].likes +" "+"likes"
        holder.description.text = postList[position].description

        Glide.with(context)
            .load(postList[position].logo)
            .into(holder.logo)

        Glide.with(context)
            .load(postList[position].photo)
            .into(holder.photo)

        
        var likesInt = postList[position].likes.filter { it.isDigit() }.toInt()


        holder.like.setOnClickListener {

            holder.like.startAnimation(popAnim)
            if (!liked) { liked = true
                holder.like.setImageResource(R.drawable.ic_liked)
                likesInt += 1
                holder.likes.text = ("${numFormat(likesInt)} likes")
            }
            else{ liked = false
                holder.like.setImageResource(R.drawable.ic_like)
                likesInt -= 1
                holder.likes.text = ("${numFormat(likesInt)} likes")
            }
        }

        holder.save.setOnClickListener {
            holder.save.startAnimation(popAnim)
            if (!saved) { saved = true
                holder.save.setImageResource(R.drawable.ic_saved) }
            else{ saved = false
                holder.save.setImageResource(R.drawable.ic_save) }
        }

        holder.photo.setOnClickListener(object : DoubleClickListener() {
            override fun onDoubleClick(v: View) {
                holder.likeOnPost.visibility = View.VISIBLE
                holder.likeOnPost.startAnimation(popAnim)
//                holder.like.startAnimation(popAnim)
                if (!liked) { liked = true
                    holder.like.setImageResource(R.drawable.ic_liked)
                    likesInt += 1
                    holder.likes.text = ("${numFormat(likesInt)} likes")
                }
                Handler(Looper.getMainLooper()).postDelayed({
                    holder.likeOnPost.visibility = View.GONE
                },1000)
            }
        })

        holder.moreDescriptionTxt.setOnClickListener {
            holder.description.isSingleLine = false
            holder.moreDescriptionTxt.visibility = View.GONE
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.brand_name)
        val logo = itemView.findViewById<ImageView>(R.id.logo)
        val photo = itemView.findViewById<ImageView>(R.id.post_img)
        val likes = itemView.findViewById<TextView>(R.id.likes_txt)
        val description = itemView.findViewById<TextView>(R.id.description_txt)
        val like = itemView.findViewById<ImageView>(R.id.like)
        val save = itemView.findViewById<ImageView>(R.id.save)
        val likeOnPost = itemView.findViewById<ImageView>(R.id.like_on_post)
        val moreDescriptionTxt = itemView.findViewById<TextView>(R.id.description_more)
    }

    fun numFormat(number: Int): String {
        return NumberFormat.getNumberInstance(Locale.US).format(number).toString()
    }
}